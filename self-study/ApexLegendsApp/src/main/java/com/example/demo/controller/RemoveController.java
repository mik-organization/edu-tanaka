package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRemoveForm;
import com.example.demo.service.RemoveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RemoveController {
	
	public final RemoveService service;
	
	
	/*--レビュー削除リクエスト（一覧画面より）---*/
	@PostMapping("/remove-review")
	public String removeReview(
			@Validated @ModelAttribute ReviewRemoveForm form,
			BindingResult result) {
		
		if (result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		return "confirm-remove-review";
	}
	
	
	/*--レビュー削除リクエスト（削除確認画面より）---*/
	@PostMapping("/confirm-remove-review")
	public String confirmRemoveReview(
			@Validated ReviewRemoveForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		//項目内容にエラーがある場合には例外を発生させる。
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



