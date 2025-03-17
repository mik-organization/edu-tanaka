package com.example.demo.service;

import com.example.demo.model.view.Review;

/** レビュー登録用のserviceインタフェース */
public interface RegistService {

  /**
   * レビュー登録処理の型定義
   *
   * @param review
   */
  void regist(Review review);
}
