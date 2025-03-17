package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewEditForm;
import com.example.demo.service.EditService;

import lombok.RequiredArgsConstructor;

/** 指定したレビューの編集を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class EditController {

  public final EditService service;

  /**
   * 編集画面表示リクエスト
   *
   * @param form
   * @return 編集画面
   */
  @PostMapping("/show-edit-form")
  public String showReviewForm(@ModelAttribute ReviewEditForm form) {

    return "edit-review";
  }

  /**
   * 編集確認画面表示リクエスト
   *
   * @param form
   * @param result validation結果
   * @return 編集画面または編集確認画面
   */
  @PostMapping("/edit-review")
  public String registReview(@Validated @ModelAttribute ReviewEditForm form, BindingResult result) {

    if (result.hasErrors()) {
      return "edit-review";
    }

    return "confirm-edit-review";
  }

  /**
   * 編集実行リクエスト
   *
   * @param form
   * @param result validation結果
   * @param redirectAttributes
   * @return 編集画面または完了画面
   */
  @PostMapping("/confirm-edit-review")
  public String confirmEditReview(
      @Validated ReviewEditForm form, BindingResult result, RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      return "edit-review";
    }

    Review r = new Review();
    r.setId(form.getId());
    r.setLegendId(form.getLegendId());
    r.setUserName(form.getUserName());
    r.setAge(form.getAge());
    r.setPlayDate(form.getPlayDate());
    r.setRating(form.getRating());
    r.setComment(form.getComment());

    service.edit(r);

    redirectAttributes.addFlashAttribute("msg", "（レビュー更新）");

    return "redirect:/complete";
  }
}
