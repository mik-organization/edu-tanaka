package com.example.demo.service;

import com.example.demo.model.view.Review;

/** レビュー削除用のserviceインタフェース */
public interface RemoveService {

  /**
   * レビュー削除処理の型定義
   *
   * @param review
   */
  void remove(Review review);
}
