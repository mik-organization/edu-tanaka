package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.NumJsonRequest;

@RestController
public class FourArithmeticController {

	/**
	 * add 加算
	 */
	@PostMapping("/add")
	public int add(@RequestBody NumJsonRequest request) {

		int result = request.num1 + request.num2;

		return result;

	}

	/**
	 * subtract 減算
	 */
	@PostMapping("/subtract")
	public int subtract(@RequestBody NumJsonRequest request) {

		int result = request.num1 - request.num2;

		return result;

	}

	/**
	 * multiply 乗算
	 */
	@PostMapping("/multiply")
	public int multiply(@RequestBody NumJsonRequest request) {

		int result = request.num1 * request.num2;

		return result;

	}

	/**
	 * divide 乗算
	 */
	@PostMapping("/divide")
	public int divide(@RequestBody NumJsonRequest request) {

		int result = request.num1 / request.num2;

		return result;

	}

}
