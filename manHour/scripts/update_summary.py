import pandas as pd
import os
import glob
from datetime import datetime

def update_time_summary():
    # パスを取得（スクリプトの場所を基準に）
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    docs_data_dir = os.path.join(base_dir, 'docs', 'data')
    manhour_data_dir = os.path.join(base_dir, 'manHour', 'data')
    
    # 予定工数のファイルパス
    docs_planned_path = os.path.join(docs_data_dir, 'planned.csv')
    manhour_planned_path = os.path.join(manhour_data_dir, 'planned.csv')
    
    # 予定工数を読み込む（両方の場所を確認）
    if os.path.exists(docs_planned_path):
        planned_path = docs_planned_path
    elif os.path.exists(manhour_planned_path):
        planned_path = manhour_planned_path
    else:
        print("予定工数ファイルが見つかりません")
        return
        
    planned_df = pd.read_csv(planned_path)
    
    # 実績データディレクトリ
    actual_dir = os.path.join(docs_data_dir, 'actual')
    if not os.path.exists(actual_dir):
        os.makedirs(actual_dir)
    
    # 実績ファイルを全て読み込む
    actual_files = glob.glob(os.path.join(actual_dir, '*.csv'))
    
    # タスクと担当者ごとの合計実績時間を計算
    task_hours = {}  # タスク全体の実績時間
    assignee_hours = {}  # タスクと担当者ごとの実績時間
    task_dates = {}  # タスクごとの作業日付（最新と最初）
    
    for file_path in actual_files:
        try:
            # ファイル名から日付を抽出
            file_date = os.path.basename(file_path).replace('.csv', '')
            
            daily_df = pd.read_csv(file_path)
            
            # assigneeカラムが存在するか確認（古いファイル形式との互換性のため）
            if 'assignee' not in daily_df.columns:
                daily_df['assignee'] = 'unknown'  # 担当者不明の場合
                
            for _, row in daily_df.iterrows():
                task_id = row['task_id']
                assignee = row['assignee'] if pd.notna(row['assignee']) else 'unknown'
                hours = row['hours']
                
                # タスク全体の合計時間を更新
                if task_id in task_hours:
                    task_hours[task_id] += hours
                else:
                    task_hours[task_id] = hours
                
                # タスクと担当者ごとの時間を更新
                task_assignee_key = f"{task_id}_{assignee}"
                if task_assignee_key in assignee_hours:
                    assignee_hours[task_assignee_key] += hours
                else:
                    assignee_hours[task_assignee_key] = hours
                
                # タスクの作業日付を記録
                if task_id not in task_dates:
                    task_dates[task_id] = {'first': file_date, 'last': file_date}
                else:
                    # 日付の比較（文字列形式YYYY-MM-DDは辞書順で比較可能）
                    if file_date < task_dates[task_id]['first']:
                        task_dates[task_id]['first'] = file_date
                    if file_date > task_dates[task_id]['last']:
                        task_dates[task_id]['last'] = file_date
                    
        except Exception as e:
            print(f"Error processing {file_path}: {e}")
    
    # タスクサマリーを作成
    summary_rows = []
    for _, planned_row in planned_df.iterrows():
        task_id = planned_row['task_id']
        planned_hours = planned_row['planned_hours']
        planned_assignee = planned_row['assignee']
        
        # 実績時間（記録がなければ0）
        actual_hours = task_hours.get(task_id, 0)
        
        # 残り時間の計算
        remaining_hours = max(0, planned_hours - actual_hours)
        
        # 進捗率の計算
        progress_percent = min(100, (actual_hours / planned_hours * 100)) if planned_hours > 0 else 0
        
        # 担当者別の実績時間を収集
        contributors = []
        for key, hours in assignee_hours.items():
            if key.startswith(f"{task_id}_"):
                assignee = key.split('_', 1)[1]
                contributors.append(f"{assignee}: {hours}時間")
        
        # 担当者別実績の文字列を作成
        contributor_str = ", ".join(contributors) if contributors else "なし"
        
        # 作業日付を取得
        first_work_date = task_dates.get(task_id, {}).get('first', '-')
        last_work_date = task_dates.get(task_id, {}).get('last', '-')
        
        # ステータスの判定
        today = datetime.now().strftime('%Y-%m-%d')
        if progress_percent >= 100:
            status = "完了"
        elif today > planned_row['end_date']:
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
            'planned_assignee': planned_assignee,
            'planned_hours': planned_hours,
            'actual_hours': actual_hours,
            'contributors': contributor_str,
            'remaining_hours': remaining_hours,
            'progress_percent': f"{progress_percent:.1f}%",
            'first_work_date': first_work_date,
            'last_work_date': last_work_date,
            'status': status,
            'planned_start': planned_row['start_date'],
            'planned_end': planned_row['end_date']
        })
    
    # サマリーをCSVに保存（両方の場所に）
    docs_summary_path = os.path.join(docs_data_dir, 'summary.csv')
    manhour_summary_path = os.path.join(manhour_data_dir, 'summary.csv')
    
    summary_df = pd.DataFrame(summary_rows)
    summary_df.to_csv(docs_summary_path, index=False)
    
    # manHourディレクトリも存在する場合はそこにも保存
    if os.path.exists(manhour_data_dir):
        summary_df.to_csv(manhour_summary_path, index=False)
    
    print(f"サマリー更新完了: {len(summary_rows)}タスク処理")
    print(f"保存先: {docs_summary_path}")
    if os.path.exists(manhour_data_dir):
        print(f"       {manhour_summary_path}")

if __name__ == "__main__":
    update_time_summary()