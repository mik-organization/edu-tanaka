package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;

import lombok.RequiredArgsConstructor;

/** レジェンドの詳細情報を実装するクラス */
@Repository
@RequiredArgsConstructor
public class LegendDetailsRepositoryImpl implements LegendDetailsRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Details> selectById(int id) {

    String sql =
        "SELECT                                "
            + "  id,                                 "
            + "  name                                "
            + "  words,                              "
            + "  picture_path,                       "
            + "  real_name,                          "
            + "  age,                                "
            + "  age_note,                           "
            + "  gender,                             "
            + "  abilities,                          "
            + "  abi_description,                    "
            + "  passive,                            "
            + "  pas_description,                    "
            + "  ult,                                "
            + "  ult_description                     "
            + "FROM                                  "
            + "  m_legend                            "
            + "WHERE                                 "
            + "  id = ?                              "
            + "ORDER BY                              "
            + "sort_index                              ";
    // SQLで検索
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, id);

    // 値の取得⇒結果の格納
    List<Details> result = new ArrayList<Details>();
    for (Map<String, Object> one : list) {
      Details details = new Details();
      details.setId((int) one.get("id"));
      details.setName((String) one.get("name"));
      details.setWords((String) one.get("words"));
      details.setPicturePath((String) one.get("picture_path"));
      details.setRealName((String) one.get("real_name"));
      // ageがnullの場合、0を格納
      Integer age = (Integer) one.get("age");
      if (age != null) {
        details.setAge(age);
      } else {
        details.setAge(0);
      }
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
