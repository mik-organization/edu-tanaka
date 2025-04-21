package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Legend;
import com.example.demo.service.LegendService;

import lombok.RequiredArgsConstructor;

/** レジェンドの新規作成・更新・削除を行うコントローラクラス */
@RestController
@RequiredArgsConstructor
@RequestMapping("/legend")
public class LegendController {

  private final LegendService service;

  /**
   * レジェンドを新規作成した結果を返します。
   *
   * @param legend レジェンドオブジェクト
   * @return 作成した結果
   */
  @PostMapping
  public ResponseEntity<Legend> create(@RequestBody Legend legend) {

    Legend createLegend = service.create(legend);

    return ResponseEntity.ok(createLegend);
  }

  /**
   * レジェンドを更新した結果を返します。
   *
   * @param id レジェンドID
   * @param legend レジェンドオブジェクト
   * @return 更新した結果
   */
  @PutMapping("/{id}")
  public ResponseEntity<Legend> update(@PathVariable Integer id, @RequestBody Legend legend) {

    Legend updateLegend = service.update(id, legend);

    return ResponseEntity.ok(updateLegend);
  }

  /**
   * レジェンドを削除した結果を返します。
   *
   * @param id レジェンドID
   * @return 削除した結果
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Integer id) {

    service.delete(id);

    return ResponseEntity.ok("レジェンドID" + id + "は削除されました。");
  }
}
