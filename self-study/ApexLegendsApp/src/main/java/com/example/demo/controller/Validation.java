package com.example.demo.controller;

import com.example.demo.controller.model.NumJsonRequest;

public class Validation {

  // 除数が0の場合、エラー表示
  public static void validationDivideRequest(NumJsonRequest request) throws IllegalArgumentException {

    if (request.getNum2() == 0) {
      throw new IllegalArgumentException("除数は0にはできません");
    }
  }
}
