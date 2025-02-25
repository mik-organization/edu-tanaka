package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.NumJsonRequest;

@RestController
@Validated
public class FourArithmeticController {

  /**
   * add 加算
   */
  @PostMapping("/add")
  public int add(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラー表示
    Validation.validationRequest(result);

    // 正常な場合は計算結果を返す
    return request.getNum1() + request.getNum2();
  }

  /**
   * subtract 減算
   */
  @PostMapping("/subtract")
  public int subtract(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラー表示
    Validation.validationRequest(result);

    // 正常な場合は計算結果を返す
    return request.getNum1() - request.getNum2();
  }

  /**
   * multiply 乗算
   */
  @PostMapping("/multiply")
  public int multiply(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラー表示
    Validation.validationRequest(result);

    // 正常な場合は計算結果を返す
    return request.getNum1() * request.getNum2();
  }

  /**
   * divide 除算
   */
  @PostMapping("/divide")
  public int divide(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラー表示
    Validation.validationDivideRequest(result, request);

    // 正常な場合は計算結果を返す
    return request.getNum1() / request.getNum2();
  }

}
