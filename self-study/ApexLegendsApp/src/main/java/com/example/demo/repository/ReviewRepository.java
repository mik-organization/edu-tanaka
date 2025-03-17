package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.view.Review;

/** レビュー処理に関するrepositoryインタフェース */
public interface ReviewRepository {

  /**
   * レビュー登録の型定義
   *
   * @param review
   */
  void add(Review review);

  /**
   * レビュー検索の型定義
   *
   * @param legendId
   * @return 指定されたレビューリスト
   */
  List<Review> selectByLegendId(int legendId);

  /**
   * レビュー更新の型定義
   *
   * @param review
   */
  void update(Review review);

  /**
   * レビュー削除の型定義
   *
   * @param review
   */
  void delete(Review review);
}
