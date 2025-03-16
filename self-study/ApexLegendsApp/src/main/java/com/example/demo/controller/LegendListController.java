package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Legend;
import com.example.demo.form.LegendSearchForm;
import com.example.demo.service.LegendListService;

import lombok.RequiredArgsConstructor;

/** レジェンドリストの表示・検索処理を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class LegendListController {

  private final LegendListService service;

  /*--最初のリクエスト-------------*/
  @GetMapping("/top")
  public String legendList(@ModelAttribute LegendSearchForm form) {

    return "legend-list";
  }

  /*--レジェンド名による検索を行う-------------*/
  @PostMapping("legend-search")
  public String ledendSearch(@ModelAttribute LegendSearchForm form, Model model) {

    List<Legend> list = service.findByNamecard(form.getName());

    model.addAttribute("legendList", list);

    return "legend-list";
  }
}
