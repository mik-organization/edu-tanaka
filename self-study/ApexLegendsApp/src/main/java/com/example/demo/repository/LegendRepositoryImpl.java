package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.view.Legend;

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
   * @return legendへ格納したリストの結果
   */
  @Override
  public List<Legend> selectByNameWildcard(String name) {

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

    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), p);

    List<Legend> result = new ArrayList<Legend>();
    for (Map<String, Object> one : list) {
      Legend legend = new Legend();
      legend.setLegendId((int) one.get("id"));
      legend.setName((String) one.get("name"));
      legend.setLegendClass((String) one.get("legend_class"));
      double d = ((BigDecimal) one.get("average_rating")).doubleValue();
      legend.setAverageRating(d);
      result.add(legend);
    }

    return result;
  }
}
