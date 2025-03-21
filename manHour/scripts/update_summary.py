import pandas as pd
import os
import glob
from datetime import datetime

def update_time_summary():
    # パスを取得（スクリプトの場所を基準に）
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    planned_path = os.path.join(base_dir, 'data', 'planned.csv')
    actual_dir = os.path.join(base_dir, 'data', 'actual')
    summary_path = os.path.join(base_dir, 'data', 'summary.csv')
    
    # 予定工数を読み込む
    planned_df = pd.read_csv(planned_path)
    
    # 実績ファイルを全て読み込む
    actual_files = glob.glob(os.path.join(actual_dir, '*.csv'))
    
    # タスクごとの合計実績時間を計算
    task_hours = {}
    for file_path in actual_files:
        try:
            daily_df = pd.read_csv(file_path)
            for _, row in daily_df.iterrows():
                task_id = row['task_id']
                hours = row['hours']
                
                if task_id in task_hours:
                    task_hours[task_id] += hours
                else:
                    task_hours[task_id] = hours
        except Exception as e:
            print(f"Error processing {file_path}: {e}")
    
    # サマリーを作成
    summary_rows = []
    for _, planned_row in planned_df.iterrows():
        task_id = planned_row['task_id']
        planned_hours = planned_row['planned_hours']
        
        # 実績時間（記録がなければ0）
        actual_hours = task_hours.get(task_id, 0)
        
        # 残り時間の計算
        remaining_hours = max(0, planned_hours - actual_hours)
        
        # 進捗率の計算
        progress_percent = min(100, (actual_hours / planned_hours * 100)) if planned_hours > 0 else 0
        
        # ステータスの判定
        if progress_percent >= 100:
            status = "完了"
        elif datetime.now().strftime('%Y-%m-%d') > planned_row['end_date']:
            status = "遅延"
        elif actual_hours > 0:
            status = "進行中"
        else:
            status = "未着手"
        
        # サマリー行を追加
        summary_rows.append({
            'task_id': task_id,
            'task_name': planned_row['task_name'],
            'category': planned_row['category'],
            'assignee': planned_row['assignee'],
            'planned_hours': planned_hours,
            'actual_hours': actual_hours,
            'remaining_hours': remaining_hours,
            'progress_percent': f"{progress_percent:.1f}%",
            'status': status
        })
    
    # サマリーをCSVに保存
    summary_df = pd.DataFrame(summary_rows)
    summary_df.to_csv(summary_path, index=False)
    print(f"サマリー更新完了: {len(summary_rows)}タスク処理")

if __name__ == "__main__":
    update_time_summary()