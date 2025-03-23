import pandas as pd
import os
from datetime import datetime
import argparse

def log_time(task_id, hours, notes=""):
    """作業時間を記録する関数"""
    # 今日の日付を取得
    today = datetime.now().strftime('%Y-%m-%d')
    
    # スクリプトのあるディレクトリから見た相対パスで保存先を指定
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))  # manHourの親ディレクトリ（リポジトリルート）
    
    # 保存先のディレクトリを設定
    # docs/data/actual に変更
    actual_dir = os.path.join(base_dir, 'docs', 'data', 'actual')
    if not os.path.exists(actual_dir):
        os.makedirs(actual_dir)
    
    # 元のパスにも保存（GitHub Actionsとの互換性のため）
    original_actual_dir = os.path.join(base_dir, 'manHour', 'data', 'actual')
    if not os.path.exists(original_actual_dir):
        os.makedirs(original_actual_dir)
    
    # 今日の記録ファイルのパス
    file_path = os.path.join(actual_dir, f'{today}.csv')
    original_file_path = os.path.join(original_actual_dir, f'{today}.csv')
    
    # CSVファイルの準備
    if os.path.exists(file_path):
        # 既存のCSVを読み込む
        df = pd.read_csv(file_path)
    else:
        # 新しいCSVを作成
        df = pd.DataFrame(columns=['task_id', 'hours', 'notes'])
    
    # 新しい行を追加
    new_row = pd.DataFrame({
        'task_id': [task_id],
        'hours': [float(hours)],
        'notes': [notes]
    })
    
    df = pd.concat([df, new_row], ignore_index=True)
    
    # CSVに保存（両方の場所に）
    df.to_csv(file_path, index=False)
    df.to_csv(original_file_path, index=False)
    
    print(f"記録完了: タスク {task_id} に {hours} 時間を追加しました")
    print(f"保存先: {file_path}")
    print(f"       {original_file_path}")

def show_tasks():
    """登録されているタスク一覧を表示する関数"""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))
    
    # planned.csvを探す（まずdocsディレクトリを確認、次にmanHourディレクトリを確認）
    docs_planned_path = os.path.join(base_dir, 'docs', 'data', 'planned.csv')
    original_planned_path = os.path.join(base_dir, 'manHour', 'data', 'planned.csv')
    
    if os.path.exists(docs_planned_path):
        planned_path = docs_planned_path
    elif os.path.exists(original_planned_path):
        planned_path = original_planned_path
    else:
        print("予定タスクが登録されていません")
        return
    
    df = pd.read_csv(planned_path)
    print("\n登録されているタスク一覧:")
    for _, row in df.iterrows():
        print(f"{row['task_id']}: {row['task_name']} (担当: {row['assignee']})")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='作業時間を記録するツール')
    parser.add_argument('--task', '-t', help='タスクID')
    parser.add_argument('--hours', '-hr', help='作業時間（時間単位）')
    parser.add_argument('--notes', '-n', help='備考', default='')
    parser.add_argument('--list', '-l', action='store_true', help='タスク一覧を表示')
    
    args = parser.parse_args()
    
    if args.list:
        show_tasks()
    elif args.task and args.hours:
        log_time(args.task, args.hours, args.notes)
    else:
        print("使い方:")
        print("  作業時間を記録: python log_time.py --task TASK-001 --hours 2.5 --notes '作業内容'")
        print("  タスク一覧を表示: python log_time.py --list")