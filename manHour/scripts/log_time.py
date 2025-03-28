import pandas as pd
import os
from datetime import datetime
import argparse

def log_time(task_id, hours, assignee=None, date=None, notes=""):
    """作業時間を記録する関数"""
    # 日付が指定されていない場合は今日の日付を使用
    if date is None:
        date = datetime.now().strftime('%Y-%m-%d')
    
    # 保存先のディレクトリを設定
    script_dir = os.path.dirname(os.path.abspath(__file__))
    base_dir = os.path.dirname(os.path.dirname(script_dir))
    actual_dir = os.path.join(base_dir, 'docs', 'data', 'actual')
    if not os.path.exists(actual_dir):
        os.makedirs(actual_dir)
    
    # 日付ごとの記録ファイルのパス
    file_path = os.path.join(actual_dir, f'{date}.csv')
    
    # ファイルが存在するか確認
    if os.path.exists(file_path):
        # 既存のCSVを読み込む
        df = pd.read_csv(file_path)
    else:
        # 新しいCSVを作成
        df = pd.DataFrame(columns=['task_id', 'assignee', 'hours', 'notes'])
    
    # 新しい行を追加
    new_row = pd.DataFrame({
        'task_id': [task_id],
        'assignee': [assignee],
        'hours': [float(hours)],
        'notes': [notes]
    })
    
    df = pd.concat([df, new_row], ignore_index=True)
    
    # CSVに保存
    df.to_csv(file_path, index=False)
    print(f"記録完了: {date} にタスク {task_id} を {assignee} が {hours} 時間実施")
    print(f"保存先: {file_path}")

# 残りのコードは同様...

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='作業時間を記録するツール')
    parser.add_argument('--task', '-t', help='タスクID')
    parser.add_argument('--hours', '-hr', help='作業時間（時間単位）')
    parser.add_argument('--assignee', '-a', help='担当者名')
    parser.add_argument('--date', '-d', help='作業日（YYYY-MM-DD形式）')
    parser.add_argument('--notes', '-n', help='備考', default='')
    parser.add_argument('--list', '-l', action='store_true', help='タスク一覧を表示')
    
    args = parser.parse_args()
    
    if args.list:
        show_tasks()
    elif args.task and args.hours:
        log_time(args.task, args.hours, args.assignee, args.date, args.notes)
    else:
        print("使い方:")
        print("  作業時間を記録: python log_time.py --task TASK-001 --hours 2.5 [--assignee yamada] [--date 2025-03-24] [--notes '作業内容']")
        print("  タスク一覧を表示: python log_time.py --list")