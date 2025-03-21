package com.example.demo.repository;

import java.util.List;
import java.util.Map;

/** レジェンド詳細表示用のrepositoryインタフェース */
public interface LegendDetailsRepository {

  /**
   * レジェンド詳細取得の型定義
   *
   * @param legendId
   * @return 検索結果
   */
  List<Map<String, Object>> selectByLegendId(int legendId);
}
