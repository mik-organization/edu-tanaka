package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

/** レジェンド詳細表示用のrepositoryクラス */
@Repository
@RequiredArgsConstructor
public class LegendDetailsRepositoryImpl implements LegendDetailsRepository {

  private final JdbcTemplate jdbcTemplate;

  /**
   * DBからレジェンド詳細を検索
   *
   * @param legendId
   * @return 検索結果
   */
  @Override
  public List<Map<String, Object>> selectByLegendId(int legendId) {

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append(" id, ");
    sql.append(" name, ");
    sql.append(" words, ");
    sql.append(" picture_path, ");
    sql.append(" real_name, ");
    sql.append(" age, ");
    sql.append(" age_note, ");
    sql.append(" gender, ");
    sql.append(" abilities, ");
    sql.append(" abi_description, ");
    sql.append(" passive, ");
    sql.append(" pas_description, ");
    sql.append(" ult, ");
    sql.append(" ult_description, ");
    sql.append(" sort_index ");
    sql.append("FROM ");
    sql.append(" m_legend ");
    sql.append("WHERE ");
    sql.append(" id = ? ");

    return jdbcTemplate.queryForList(sql.toString(), legendId);
  }
}
