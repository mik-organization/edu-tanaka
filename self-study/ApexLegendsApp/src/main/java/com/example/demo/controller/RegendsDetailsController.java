package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Details;
import com.example.demo.form.ReviewSearchForm;
import com.example.demo.service.RegendsDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegendsDetailsController {
	
	private final RegendsDetailsService service;
	
	@PostMapping("/regends-details")
	private String regendsDetails(
			@ModelAttribute ReviewSearchForm form,
			Model model) {
		
		List<Details> list
			= service.findByRegendsId(form.getRegendsId());
		
		if (list.size() > 0) {
		model.addAttribute("regendsDetails", list);
		
		}
		
		return "regends-details";
	}
	

}
