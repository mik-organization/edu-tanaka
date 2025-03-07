package com.example.demo.controller.validator;

import com.example.demo.model.request.CalcRequest;

public class Validation {

  public static void validationDivideRequest(CalcRequest request) throws IllegalArgumentException {

    if (request.getNum2() == 0) {
      throw new IllegalArgumentException("除数は0にはできません");
    }
  }
}
