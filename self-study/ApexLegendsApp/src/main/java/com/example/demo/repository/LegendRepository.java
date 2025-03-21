package com.example.demo.repository;

import java.util.List;
import java.util.Map;

/** レジェンド検索用のrepositoryインタフェース */
public interface LegendRepository {

  /**
   * レジェンド検索の型定義
   *
   * @param name
   * @return 検索結果
   */
  List<Map<String, Object>> selectByNameWildcard(String name);
}
