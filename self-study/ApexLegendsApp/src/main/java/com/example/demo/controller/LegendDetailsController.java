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

@Controller
@RequiredArgsConstructor
public class LegendDetailsController {
	
	private final LegendDetailsService service;
	
	@PostMapping("/legend-details")
	private String legendDetails(
			@ModelAttribute ReviewSearchForm form,
			Model model) {
		
		List<Details> list
			= service.findById(form.getId());
		
		if (list.size() > 0) {
		model.addAttribute("legensDetails", list);
		
		}
		
		return "legend-details";
	}
	

}
