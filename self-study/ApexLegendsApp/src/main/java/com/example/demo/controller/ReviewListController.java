package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewSearchForm;
import com.example.demo.service.ReviewListService;

import lombok.RequiredArgsConstructor;

/** レビューリストの表示・検索を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class ReviewListController {

  private final ReviewListService service;

  /**
   * レジェンドIDによるレビュー検索
   *
   * @param form
   * @param model
   * @return レビュー一覧画面
   */
  @PostMapping("/search-review")
  private String searchReview(@ModelAttribute ReviewSearchForm form, Model model) {

    List<Review> list = service.findByLegendId(form.getLegendId());

    if (list.size() > 0) {
      model.addAttribute("reviewList", list);
    }

    return "review-list";
  }
}
