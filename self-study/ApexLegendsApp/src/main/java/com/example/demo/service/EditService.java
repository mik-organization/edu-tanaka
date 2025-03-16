package com.example.demo.service;

import com.example.demo.entity.Review;

/** レビュー編集用のserviceインタフェース */
public interface EditService {

  /**
   * レビュー編集処理の型定義
   *
   * @param review
   */
  void edit(Review review);
}
