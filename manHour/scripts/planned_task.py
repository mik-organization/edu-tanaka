import pandas as pd
import os
import argparse
from datetime import datetime

def add_task(task_id, task_name, category, assignee, planned_hours, start_date, end_date):
    """新しいタスクを予定表に追加する関数"""
    # スクリプトのあるディレクトリから見た相対パスで保存先を指定
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))  # manHourの親ディレクトリ（リポジトリルート）
    
    # 保存先のファイルパスを設定（両方の場所）
    docs_data_dir = os.path.join(base_dir, 'docs', 'data')
    manhour_data_dir = os.path.join(base_dir, 'manHour', 'data')
    
    # ディレクトリが存在しない場合は作成
    if not os.path.exists(docs_data_dir):
        os.makedirs(docs_data_dir)
    if not os.path.exists(manhour_data_dir):
        os.makedirs(manhour_data_dir)
    
    docs_planned_path = os.path.join(docs_data_dir, 'planned.csv')
    manhour_planned_path = os.path.join(manhour_data_dir, 'planned.csv')
    
    # CSVファイルが既に存在するかチェック
    if os.path.exists(docs_planned_path):
        df = pd.read_csv(docs_planned_path)
    else:
        # 新しいCSVを作成
        df = pd.DataFrame(columns=['task_id', 'task_name', 'category', 'assignee', 
                                   'planned_hours', 'start_date', 'end_date'])
    
    # タスクIDが既に存在するか確認
    if task_id in df['task_id'].values:
        # 既存のタスクを更新
        idx = df[df['task_id'] == task_id].index[0]
        df.loc[idx, 'task_name'] = task_name
        df.loc[idx, 'category'] = category
        df.loc[idx, 'assignee'] = assignee
        df.loc[idx, 'planned_hours'] = float(planned_hours)
        df.loc[idx, 'start_date'] = start_date
        df.loc[idx, 'end_date'] = end_date
        print(f"タスク {task_id} を更新しました")
    else:
        # 新しいタスクを追加
        new_row = pd.DataFrame({
            'task_id': [task_id],
            'task_name': [task_name],
            'category': [category],
            'assignee': [assignee],
            'planned_hours': [float(planned_hours)],
            'start_date': [start_date],
            'end_date': [end_date]
        })
        df = pd.concat([df, new_row], ignore_index=True)
        print(f"新しいタスク {task_id} を追加しました")
    
    # 両方の場所にCSVを保存
    df.to_csv(docs_planned_path, index=False)
    df.to_csv(manhour_planned_path, index=False)
    
    print(f"保存先: {docs_planned_path}")
    print(f"       {manhour_planned_path}")

def delete_task(task_id):
    """タスクを予定表から削除する関数"""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))
    
    docs_planned_path = os.path.join(base_dir, 'docs', 'data', 'planned.csv')
    manhour_planned_path = os.path.join(base_dir, 'manHour', 'data', 'planned.csv')
    
    # CSVファイルが存在するか確認
    if not os.path.exists(docs_planned_path):
        print("予定タスクファイルが見つかりません")
        return
    
    df = pd.read_csv(docs_planned_path)
    
    # タスクIDが存在するか確認
    if task_id not in df['task_id'].values:
        print(f"タスク {task_id} は見つかりません")
        return
    
    # タスクを削除
    df = df[df['task_id'] != task_id]
    
    # 両方の場所にCSVを保存
    df.to_csv(docs_planned_path, index=False)
    df.to_csv(manhour_planned_path, index=False)
    
    print(f"タスク {task_id} を削除しました")

def list_tasks():
    """登録されているタスク一覧を表示する関数"""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))
    
    docs_planned_path = os.path.join(base_dir, 'docs', 'data', 'planned.csv')
    manhour_planned_path = os.path.join(base_dir, 'manHour', 'data', 'planned.csv')
    
    if os.path.exists(docs_planned_path):
        planned_path = docs_planned_path
    elif os.path.exists(manhour_planned_path):
        planned_path = manhour_planned_path
    else:
        print("予定タスクが登録されていません")
        return
    
    df = pd.read_csv(planned_path)
    
    if df.empty:
        print("予定タスクが登録されていません")
        return
    
    print("\n登録されているタスク一覧:")
    print("-" * 100)
    print(f"{'タスクID':<10} {'タスク名':<20} {'カテゴリ':<10} {'担当者':<10} {'予定時間':<10} {'開始日':<12} {'終了日':<12}")
    print("-" * 100)
    
    for _, row in df.iterrows():
        print(f"{row['task_id']:<10} {row['task_name']:<20} {row['category']:<10} {row['assignee']:<10} "
              f"{row['planned_hours']:<10.1f} {row['start_date']:<12} {row['end_date']:<12}")

def validate_date(date_text):
    """日付形式（YYYY-MM-DD）をバリデーションする関数"""
    try:
        datetime.strptime(date_text, '%Y-%m-%d')
        return True
    except ValueError:
        return False

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='予定工数を管理するツール')
    
    subparsers = parser.add_subparsers(dest='command', help='コマンド')
    
    # タスク追加のコマンド
    add_parser = subparsers.add_parser('add', help='タスクを追加')
    add_parser.add_argument('--id', required=True, help='タスクID（例: TASK-001）')
    add_parser.add_argument('--name', required=True, help='タスク名')
    add_parser.add_argument('--category', required=True, help='カテゴリ（例: 分析, 設計, 実装）')
    add_parser.add_argument('--assignee', required=True, help='担当者名')
    add_parser.add_argument('--hours', required=True, type=float, help='予定工数（時間）')
    add_parser.add_argument('--start', required=True, help='開始日（YYYY-MM-DD形式）')
    add_parser.add_argument('--end', required=True, help='終了日（YYYY-MM-DD形式）')
    
    # タスク削除のコマンド
    delete_parser = subparsers.add_parser('delete', help='タスクを削除')
    delete_parser.add_argument('--id', required=True, help='削除するタスクID')
    
    # タスク一覧表示のコマンド
    list_parser = subparsers.add_parser('list', help='タスク一覧を表示')
    
    args = parser.parse_args()
    
    if args.command == 'add':
        # 日付形式のバリデーション
        if not validate_date(args.start) or not validate_date(args.end):
            print("エラー: 日付はYYYY-MM-DD形式で入力してください（例: 2025-03-24）")
        else:
            add_task(args.id, args.name, args.category, args.assignee, args.hours, args.start, args.end)
    
    elif args.command == 'delete':
        delete_task(args.id)
    
    elif args.command == 'list':
        list_tasks()
    
    else:
        parser.print_help()