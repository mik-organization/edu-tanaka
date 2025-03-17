package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.view.Details;

/** レジェンド詳細表示用のrepositoryインタフェース */
public interface LegendDetailsRepository {

  /**
   * レジェンド詳細取得の型定義
   *
   * @param legendId
   * @return 指定されたレジェンド詳細リスト
   */
  List<Details> selectByLegendId(int legendId);
}
