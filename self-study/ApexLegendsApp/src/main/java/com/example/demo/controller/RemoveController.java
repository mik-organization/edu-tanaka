package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ReviewRemoveForm;
import com.example.demo.model.view.Review;
import com.example.demo.service.RemoveService;

import lombok.RequiredArgsConstructor;

/** 指定したレビューの削除を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class RemoveController {

  public final RemoveService service;

  /**
   * 削除確認画面表示リクエスト
   *
   * @param form
   * @param result validation結果
   * @return エラーまたは削除確認画面
   */
  @PostMapping("/remove-review")
  public String removeReview(
      @Validated @ModelAttribute ReviewRemoveForm form, BindingResult result) {

    if (result.hasErrors()) {
      throw new IllegalArgumentException("**removeReview()**");
    }

    return "confirm-remove-review";
  }

  /**
   * 削除実行リクエスト
   *
   * @param form
   * @param result validation結果
   * @param redirectAttributes
   * @return エラーまたは完了画面
   */
  @PostMapping("/confirm-remove-review")
  public String confirmRemoveReview(
      @Validated ReviewRemoveForm form,
      BindingResult result,
      RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      throw new IllegalArgumentException("**confirmReview()**");
    }

    Review r = new Review();
    r.setId(form.getId());
    r.setLegendId(form.getLegendId());
    r.setUserName(form.getUserName());
    r.setAge(form.getAge());
    r.setPlayDate(form.getPlayDate());
    r.setRating(form.getRating());
    r.setComment(form.getComment());

    service.remove(r);

    redirectAttributes.addFlashAttribute("msg", "（レビュー削除）");

    return "redirect:/complete";
  }
}
