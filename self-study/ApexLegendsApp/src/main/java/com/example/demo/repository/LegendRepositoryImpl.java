package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

/** レジェンド検索用のrepositoryクラス */
@Repository
@RequiredArgsConstructor
public class LegendRepositoryImpl implements LegendRepository {

  private final JdbcTemplate jdbcTemplate;

  /**
   * DBからレジェンドを検索
   *
   * @param name
   * @return 検索結果
   */
  @Override
  public List<Map<String, Object>> selectByNameWildcard(String name) {

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append(" ml.id, ");
    sql.append(" ml.name, ");
    sql.append(" ml.legend_class, ");
    sql.append(" COALESCE(AVG(tr.rating), 0.0 ) average_rating ");
    sql.append("FROM ");
    sql.append(" m_legend ml ");
    sql.append(" LEFT OUTER JOIN t_review tr ");
    sql.append(" ON ml.id = tr.legend_id ");
    sql.append("WHERE ");
    sql.append(" ml.name LIKE ? ");
    sql.append("GROUP BY ");
    sql.append(" ml.id, ");
    sql.append(" ml.name, ");
    sql.append(" ml.legend_class ");
    sql.append("ORDER BY ");
    sql.append(" ml.sort_index ");

    String p = "%" + name + "%";

    return jdbcTemplate.queryForList(sql.toString(), p);
  }
}
