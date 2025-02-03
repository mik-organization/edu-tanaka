package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Regends;
import com.example.demo.form.RegendsSearchForm;
import com.example.demo.service.RegendsListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegendsListController {
	
	private final RegendsListService service;

	/*--最初のリクエスト-------------*/
	@GetMapping("/top")
	public String regendsList(
			@ModelAttribute RegendsSearchForm form) {
			
		return "regends-list";
	}
	
	/*--検索リクエスト-------------*/
	@PostMapping("/regends-search")
	public String redendsSearch( 
			@ModelAttribute RegendsSearchForm form,
			Model model) {
	
		List<Regends>list
			=service.findByNamecard(form.getRegendsName());
		
		model.addAttribute("regendsList",list);
		
		return "regends-list";
	}
	
	
	
}

