package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.view.Details;

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
   * @return detailsへ格納したリストの結果
   */
  @Override
  public List<Details> selectByLegendId(int legendId) {

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

    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), legendId);

    List<Details> result = new ArrayList<Details>();
    for (Map<String, Object> one : list) {
      Details details = new Details();
      details.setLegendId((int) one.get("id"));
      details.setName((String) one.get("name"));
      details.setWords((String) one.get("words"));
      details.setPicturePath((String) one.get("picture_path"));
      details.setRealName((String) one.get("real_name"));
      details.setAge((Integer) one.get("age"));
      details.setAgeNote((String) one.get("age_note"));
      details.setGender((String) one.get("gender"));
      details.setAbilities((String) one.get("abilities"));
      details.setAbiDescription((String) one.get("abi_description"));
      details.setPassive((String) one.get("passive"));
      details.setPasDescripition((String) one.get("pas_description"));
      details.setUlt((String) one.get("ult"));
      details.setUltDescripition((String) one.get("ult_description"));
      result.add(details);
    }

    return result;
  }
}
