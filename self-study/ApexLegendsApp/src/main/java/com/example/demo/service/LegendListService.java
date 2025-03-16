package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Legend;

/** レジェンド検索処理用のserviceインタフェース */
public interface LegendListService {

  /**
   * レジェンド検索処理の型定義
   *
   * @param name
   * @return 指定されたレジェンドリスト
   */
  List<Legend> findByNamecard(String name);
}
