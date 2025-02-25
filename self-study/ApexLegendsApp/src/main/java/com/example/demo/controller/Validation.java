package com.example.demo.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.example.demo.controller.model.NumJsonRequest;

public class Validation {

  public static void validationRequest(BindingResult result) throws BindException {

    // 入力内容にエラーがある場合は、エラーメッセージを返す
    if (result.hasErrors()) {
      throw new BindException(result);
    }
  }

  // 除算のみnum2が0のとき、エラーメッセージを返す
  public static void validationDivideRequest(BindingResult result, NumJsonRequest request) throws BindException {

    validationRequest(result);
    if (request.getNum2() == 0) {
      throw new IllegalArgumentException("除数は0にはできません");
    }
  }
}
