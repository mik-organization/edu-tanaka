package com.example.demo.controller.validator;

import com.example.demo.model.request.CalcRequest;

public class Validation {

  public static void validationDivideRequest(CalcRequest request) throws IllegalArgumentException {
  // 除数が0の場合、エラー表示
    if (request.getNum2() == 0) {
      throw new IllegalArgumentException("除数は0にはできません");
    }
  }
}
