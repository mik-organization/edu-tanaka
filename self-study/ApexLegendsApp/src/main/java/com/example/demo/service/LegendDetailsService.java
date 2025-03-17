package com.example.demo.service;

import java.util.List;

import com.example.demo.model.view.Details;

/** レジェンド詳細表示用のserviceインタフェース */
public interface LegendDetailsService {

  /**
   * レジェンド詳細取得の型定義
   *
   * @param legendId
   * @return 指定されたレジェンド詳細リスト
   */
  List<Details> findByLegendId(int legendId);
}
