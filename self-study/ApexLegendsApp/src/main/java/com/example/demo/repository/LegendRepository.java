package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Legend;

/** レジェンド検索用のrepositoryインタフェース */
public interface LegendRepository {

  /**
   * レジェンド検索の型定義
   *
   * @param name
   * @return 指定されたレジェンドリスト
   */
  List<Legend> selectByNameWildcard(String name);
}
