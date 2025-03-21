package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.view.Review;

import lombok.RequiredArgsConstructor;

/** レビュー処理に関するrepositoryクラス */
@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

  private final JdbcTemplate jdbcTemplate;

  /**
   * DBにレビューを登録
   *
   * @param review
   */
  @Override
  public void add(Review review) {

    String sql =
        "INSERT INTO t_review"
            + "(legend_id, user_name, age, play_date, rating, comment)"
            + "VALUES(?, ?, ?, ?, ?, ? )";

    jdbcTemplate.update(
        sql,
        review.getLegendId(),
        review.getUserName(),
        review.getAge(),
        review.getPlayDate(),
        review.getRating(),
        review.getComment());
  }

  /**
   * DBからレビューを検索
   *
   * @param legendId
   * @return 検索結果
   */
  @Override
  public List<Map<String, Object>> selectByLegendId(int legendId) {

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append("  id, ");
    sql.append("  legend_id, ");
    sql.append("  user_name, ");
    sql.append("  age, ");
    sql.append("  play_date, ");
    sql.append("  rating, ");
    sql.append("  comment ");
    sql.append("FROM ");
    sql.append("  t_review ");
    sql.append("WHERE ");
    sql.append("  legend_id = ? ");
    sql.append("ORDER BY ");
    sql.append("  play_date DESC, ");
    sql.append("  id ASC ");

    return jdbcTemplate.queryForList(sql.toString(), legendId);
  }

  /**
   * DB内のレビュー更新
   *
   * @param review
   */
  @Override
  public void update(Review review) {

    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE ");
    sql.append("  t_review ");
    sql.append("SET ");
    sql.append("  user_name = ?, ");
    sql.append("  age = ?, ");
    sql.append("  play_date = ?, ");
    sql.append("  rating = ?, ");
    sql.append("  comment = ? ");
    sql.append("WHERE ");
    sql.append("  id = ?");

    jdbcTemplate.update(
        sql.toString(),
        review.getUserName(),
        review.getAge(),
        review.getPlayDate(),
        review.getRating(),
        review.getComment(),
        review.getId());
  }

  /**
   * DBからレビューを削除
   *
   * @param review
   */
  @Override
  public void delete(Review review) {

    String sql = "DELETE	 FROM t_review WHERE	 id = ?	";

    jdbcTemplate.update(sql, review.getId());
  }
}
