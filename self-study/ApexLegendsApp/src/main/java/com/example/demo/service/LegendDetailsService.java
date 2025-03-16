package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Details;

/**LegendDetailsServiceインタフェース */
public interface LegendDetailsService {

  /**
   * Detailsクラスのリスト取得
   *
   * @param id
   * @return 詳細リスト
   */
  List<Details> findByLegendId(int legendId);
}
