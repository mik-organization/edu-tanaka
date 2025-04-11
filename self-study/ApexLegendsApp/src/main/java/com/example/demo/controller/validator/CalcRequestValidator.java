package com.example.demo.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.request.CalcRequest;

@Component
public class CalcRequestValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return CalcRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors e) {
    CalcRequest request = (CalcRequest) target;

    if (request.getNum2() == 0) {
      e.rejectValue("num2", "除数(num2)は0にできません。");
    }
  }
}
