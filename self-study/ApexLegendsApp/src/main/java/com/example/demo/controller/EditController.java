package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ReviewEditForm;
import com.example.demo.model.view.Review;
import com.example.demo.service.EditService;

import lombok.RequiredArgsConstructor;

/** 指定したレビューの編集を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class EditController {

  public final EditService service;

  /**
   * レビュー編集画面を表示します。
   *
   * @param form レビュー編集フォーム
   * @return レビュー編集画面のテンプレート名
   */
  @PostMapping("/show-edit-form")
  public String showReviewForm(@ModelAttribute ReviewEditForm form) {

    return "edit-review";
  }

  /**
   * レビュー編集画面またはレビュー編集確認画面を表示します。
   *
   * @param form レビュー編集フォーム
   * @param result バリデーション結果
   * @return レビュー編集画面のテンプレート名またはレビュー編集確認画面のテンプレート名
   */
  @PostMapping("/edit-review")
  public String registReview(@Validated @ModelAttribute ReviewEditForm form, BindingResult result) {

    if (result.hasErrors()) {
      return "edit-review";
    }

    return "confirm-edit-review";
  }

  /**
   * レビュー編集画面またはレビュー更新を実行しレビュー完了画面を表示します。
   *
   * @param form レビュー編集フォーム
   * @param result バリデーション結果
   * @param redirectAttributes リダイレクト属性
   * @return レビュー編集画面のテンプレート名またはレビュー完了画面へのリダイレクトURL
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
