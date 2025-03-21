package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.view.Details;
import com.example.demo.repository.LegendDetailsRepository;

import lombok.RequiredArgsConstructor;

/** レジェンド詳細表示用のserviceクラス */
@Repository
@RequiredArgsConstructor
public class LegendDetailsServiceImpl implements LegendDetailsService {

  private final LegendDetailsRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param legendId
   * @return detailsに格納したＬｉｓｔ
   */
  @Override
  public List<Details> findByLegendId(int legendId) {

    List<Map<String, Object>> list = repository.selectByLegendId(legendId);

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
