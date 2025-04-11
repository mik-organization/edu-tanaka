package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Legend;
import com.example.demo.repository.LegendApiRepository;

import lombok.RequiredArgsConstructor;

/** レジェンドの新規作成・更新・削除を行うサービスクラス */
@Service
@RequiredArgsConstructor
public class LegendService {

  private final LegendApiRepository repository;

  /**
   * レジェンドを新規作成し、作成結果を返します。
   *
   * @param legend レジェンドオブジェクト
   * @return 作成したレジェンド
   */
  public Legend create(Legend legend) {

    return repository.save(legend);
  }

  /**
   * レジェンドの更新をし、更新結果を返します。
   *
   * @param id レジェンドID
   * @param legend レジェンドオブジェクト
   * @return 更新したレジェンド
   * @throws IllegalArgumentException レジェンドＩＤが見つからない場合発生
   */
  public Legend update(Integer id, Legend legend) {
    Optional<Legend> existingLegend = repository.findById(id);
    if (existingLegend.isPresent()) {
      var v = existingLegend.get();
      v.setName(legend.getName());
      v.setRealName(legend.getRealName());
      v.setAge(legend.getAge());
      v.setAgeNote(legend.getAgeNote());
      v.setGender(legend.getGender());
      v.setLegendClass(legend.getLegendClass());
      v.setAbilities(legend.getAbilities());
      v.setAbiDescription(legend.getAbiDescription());
      v.setPassive(legend.getPassive());
      v.setPasDescripition(legend.getPasDescripition());
      v.setUlt(legend.getUlt());
      v.setUltDescripition(legend.getUltDescripition());
      v.setWords(legend.getWords());
      v.setPicturePath(legend.getPicturePath());
      v.setSortIndex(legend.getSortIndex());

      return repository.save(v);
    } else {
      throw new IllegalArgumentException("レジェンドID" + id + "は見つかりません。");
    }
  }

  /**
   * レジェンドを削除します。
   *
   * @param id レジェンドＩＤ
   * @throws IllegalArgumentException レジェンドＩＤが見つからない場合発生
   */
  public void delete(Integer id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new IllegalArgumentException("レジェンドID" + id + "は見つかりません。");
    }
    repository.deleteById(id);
  }
}
