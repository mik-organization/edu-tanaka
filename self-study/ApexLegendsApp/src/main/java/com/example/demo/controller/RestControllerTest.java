package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {
	@GetMapping("/getstring")
	public String getString() {
		return "string test";
	}

}
