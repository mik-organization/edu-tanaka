package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Review;

/** レビューリスト表示用のserviceインタフェース */
public interface ReviewListService {

  /**
   * レビュー表示処理の型定義
   *
   * @param legendId
   * @return 指定されたレビューリスト
   */
  List<Review> findByLegendId(int legendId);
}
