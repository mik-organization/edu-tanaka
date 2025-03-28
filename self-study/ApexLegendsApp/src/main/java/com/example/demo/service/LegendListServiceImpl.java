package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.view.Legend;
import com.example.demo.repository.LegendRepository;

import lombok.RequiredArgsConstructor;

/** レジェンド検索処理用のserviceクラス */
@Service
@RequiredArgsConstructor
public class LegendListServiceImpl implements LegendListService {

  private final LegendRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param name
   * @return legendに格納したList
   */
  @Override
  public List<Legend> findByNamecard(String name) {

    List<Map<String, Object>> list = repository.selectByNameWildcard(name);

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
