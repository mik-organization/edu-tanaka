package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;

import lombok.RequiredArgsConstructor;

/** レジェンド詳細表示用のrepositoryクラス */
@Repository
@RequiredArgsConstructor
public class LegendDetailsRepositoryImpl implements LegendDetailsRepository {

  private final JdbcTemplate jdbcTemplate;

  /**
 * レジェンド詳細のDB検索
 * @param legendId
 * @return 結果
 */
@Override
  public List<Details> selectByLegendId(int legendId) {

    String sql =
        "SELECT                                "
            + "  id,                                 "
            + "  name,                                "
            + "  words,                              "
            + "  picture_path,                       "
            + "  real_name,                          "
            + "  age,                                       "
            + "  age_note,  "
            + "  gender,                             "
            + "  abilities,                          "
            + "  abi_description,                    "
            + "  passive,                            "
            + "  pas_description,                    "
            + "  ult,                                "
            + "  ult_description,                     "
            + "  sort_index                    "
            + "FROM                                  "
            + "  m_legend                            "
            + "WHERE                                 "
            + "  id = ?                              ";

    // SQLで検索
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, legendId);

    // 値の取得⇒結果の格納
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
