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

/** レビュー登録を行うコントローラー */
@Controller
@RequiredArgsConstructor
public class RegistController {

  public final RegistService service;

  /*--レビュー登録画面表示リクエスト---*/
  @PostMapping("/show-review-form")
  public String showReviewForm(@ModelAttribute ReviewRegistForm form) {

    return "regist-review";
  }

  /*--レビュー登録確認画面表示リクエスト（確認画面からの戻り）---*/
  @PostMapping("/show-review-form-ret")
  public String showRrviewFormRet(@ModelAttribute ReviewRegistForm form) {

    return "regist-review";
  }

  /*--レビュー登録確認画面表示リクエスト（確認画面）---*/
  @PostMapping("/regist-review")
  public String registReview(
      @Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {

    if (result.hasErrors()) {
      return "regist-review";
    }

    return "confirm-regist-review";
  }

  /*--レビュー登録画面リクエスト（登録画面より）---*/
  @PostMapping("/confirm-regist-review")
  public String confirmRegistReview(
      @Validated ReviewRegistForm form,
      BindingResult result,
      RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {

      return "regist-review";
    }

    Review r = new Review();
    r.setLegendId(form.getId());
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
