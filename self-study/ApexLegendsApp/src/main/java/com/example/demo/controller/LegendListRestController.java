package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.LegendSearchForm;
import com.example.demo.model.view.Legend;
import com.example.demo.service.LegendListService;

import lombok.RequiredArgsConstructor;

/** レジェンドリストの表示・検索処理を行うコントローラー */
@RestController
@RequiredArgsConstructor
public class LegendListRestController {

  private final LegendListService service;

  /*--レジェンド名による検索を行う-------------*/
  @PostMapping("search")
  @ResponseBody
  public List<Legend> ledendSearch(@RequestBody LegendSearchForm form) {

    List<Legend> list = service.findByNamecard(form.getName());

    return list;
  }
}
