package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Details;
import com.example.demo.form.ReviewSearchForm;
import com.example.demo.service.LegendDetailsService;

import lombok.RequiredArgsConstructor;

/** 指定したレジェンドの詳細を表示するコントローラー */
@Controller
@RequiredArgsConstructor
public class LegendDetailsController {

  private final LegendDetailsService service;

  /**
   * 指定したレジェンドの詳細データを取得
   *
   * @param form
   * @param model
   * @return
   */
  @PostMapping("/legend-details")
  private String legendDetails(@ModelAttribute ReviewSearchForm form, Model model) {

    List<Details> list = service.findByLegendId(form.getLegendId()); 
    
    System.out.println(list); 

    if (list.size() > 0) {
      model.addAttribute("legendDetails", list);
    }

    return "legend-details";
  }
}
