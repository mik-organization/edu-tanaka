package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Legend;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LegendRepositoryImpl implements LegendRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Legend> selectByNameWildcard(String name) {

    String sql =
        "SELECT                                               "
            + "	ml.id,                                        "
            + "	ml.name,                                      "
            + "	ml.legend_class                               "
            + "	COALESCE(AVG(tr.rating), 0.0 ) average_rating "
            + "FROM                                           "
            + "	m_legend ml                                   "
            + "	LEFT OUTER JOIN t_review tr                   "
            + " 				 ON ml.id = tr.legend_id      "
            + "WHERE                                          "
            + "	ml.name LIKE ?                                "
            + "GROUP BY                                       "
            + "	ml.id,                                        "
            + "	ml.name,                                      "
            + "	ml.legend_class                               "
            + "ORDER BY                                       "
            + "	ml.id                                         ";

    String p = "%" + name + "%"; // プレースホルダの値

    // SQLで検索（プレースホルダ：p）
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);

    // 値の取得⇒結果の格納
    List<Legend> result = new ArrayList<Legend>(); // 結果の初期化
    for (Map<String, Object> one : list) {
      Legend legend = new Legend();
      legend.setId((int) one.get("id"));
      legend.setName((String) one.get("name"));
      legend.setLegendClass((String) one.get("legend_class"));
      double d = ((BigDecimal) one.get("average_rating")).doubleValue();
      legend.setAverageRating(d);
      result.add(legend);
    }

    return result;
  }
}
