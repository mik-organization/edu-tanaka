package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

/** レビューの登録を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class RegistController {

  public final RegistService service;

  /**
   * 登録画面表示リクエスト
   *
   * @param form
   * @return 登録画面
   */
  @PostMapping("/show-review-form")
  public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
    System.out.println(form.getLegendId());

    return "regist-review";
  }

  /**
   * 登録画面表示リクエスト（確認画面からの戻り）
   *
   * @param form
   * @return 登録画面
   */
  @PostMapping("/show-review-form-ret")
  public String showRrviewFormRet(@ModelAttribute ReviewRegistForm form) {

    return "regist-review";
  }

  /**
   * 登録確認画面表示リクエスト
   *
   * @param form
   * @param result validation結果
   * @return 登録画面または登録確認画面
   */
  @PostMapping("/regist-review")
  public String registReview(
      @Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {

    if (result.hasErrors()) {
      return "regist-review";
    }

    return "confirm-regist-review";
  }

  /**
   * 登録実行リクエスト
   *
   * @param form
   * @param result validation結果
   * @param redirectAttributes
   * @return 登録画面または完了画面
   */
  @PostMapping("/confirm-regist-review")
  public String confirmRegistReview(
      @Validated ReviewRegistForm form,
      BindingResult result,
      RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      return "regist-review";
    }

    Review r = new Review();
    r.setLegendId(form.getLegendId());
    r.setUserName(form.getUserName());
    r.setAge(form.getAge());
    r.setPlayDate(form.getPlayDate());
    r.setRating(form.getRating());
    r.setComment(form.getComment());

    service.regist(r);

    redirectAttributes.addFlashAttribute("msg", "（レビュー登録）");

    return "redirect:/complete";
  }
}
