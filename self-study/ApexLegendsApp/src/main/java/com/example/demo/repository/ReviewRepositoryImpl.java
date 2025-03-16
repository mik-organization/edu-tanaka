package com.example.demo.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

  private final JdbcTemplate jdbcTemplate;

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

  @Override
  public List<Review> selectByLegendId(int legendId) {

    String sql =
        "SELECT                                 "
            + "	id,                                 "
            + "	legend_id,                          "
            + "	user_name,                          "
            + "	age,                                "
            + "	play_date,                          "
            + "	rating,                             "
            + "	comment                             "
            + "FROM                                   "
            + "	t_review                            "
            + "WHERE                                  "
            + "	legend_id = ?                       "
            + "ORDER BY                               "
            + "	play_date DESC,                     "
            + "	id ASC                              ";

    // SQLで検索（プレースホルダ：引数で受け取ってlegendId）
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, legendId);

    // 値の取得⇒結果の格納
    List<Review> result = new ArrayList<Review>(); // 結果の初期化
    for (Map<String, Object> one : list) {
      Review review = new Review();
      review.setId((int) one.get("id"));
      review.setLegendId((int) one.get("legend_id"));
      review.setUserName((String) one.get("user_name"));
      review.setAge((Integer) one.get("age"));
      review.setPlayDate((Date) one.get("play_date"));
      review.setRating((Integer) one.get("rating"));
      review.setComment((String) one.get("comment"));
      result.add(review);
    }

    return result;
  }

  @Override
  public void update(Review review) {

    String sql =
        "UPDATE               "
            + "	t_review          "
            + "SET                  "
            + "	user_name = ?,    "
            + "	age	= ?,          "
            + "	play_date = ?,    "
            + "	rating = ?,       "
            + "   comment = ?       "
            + "WHERE                "
            + "	id = ?            ";

    jdbcTemplate.update(
        sql,
        review.getUserName(),
        review.getAge(),
        review.getPlayDate(),
        review.getRating(),
        review.getComment(),
        review.getId());
  }

  @Override
  public void delete(Review review) {

    String sql = "DELETE	 FROM t_review WHERE	 id = ?	";

    jdbcTemplate.update(sql, review.getId());
  }
}
