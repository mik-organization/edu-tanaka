import pandas as pd
import os
from datetime import datetime
import argparse

def log_time(task_id, hours, notes=""):
    """作業時間を記録する関数"""
    # 今日の日付を取得
    today = datetime.now().strftime('%Y-%m-%d')
    
    # 保存先のディレクトリを確認
    actual_dir = 'data/actual'
    if not os.path.exists(actual_dir):
        os.makedirs(actual_dir)
    
    # 今日の記録ファイルのパス
    file_path = f'{actual_dir}/{today}.csv'
    
    # ファイルが存在するか確認
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
    
    # CSVに保存
    df.to_csv(file_path, index=False)
    print(f"記録完了: タスク {task_id} に {hours} 時間を追加しました")

def show_tasks():
    """登録されているタスク一覧を表示する関数"""
    if os.path.exists('data/planned.csv'):
        df = pd.read_csv('data/planned.csv')
        print("\n登録されているタスク一覧:")
        for _, row in df.iterrows():
            print(f"{row['task_id']}: {row['task_name']} (担当: {row['assignee']})")
    else:
        print("予定タスクが登録されていません")

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
