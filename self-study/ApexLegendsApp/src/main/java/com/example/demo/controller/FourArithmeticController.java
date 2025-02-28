package com.example.demo.controller;

import java.math.BigDecimal;

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

    // 入力内容チェックし、エラーがある場合はメッセージを返す
    Validation.validationRequest(result);

    // 正常な場合は計算結果を返す
    return request.getNum1() + request.getNum2();
  }

  /**
   * subtract 減算
   */
  @PostMapping("/subtract")
  public int subtract(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラーがある場合はメッセージを返す
    Validation.validationRequest(result);

    // 正常な場合は計算結果を返す
    return request.getNum1() - request.getNum2();
  }

  /**
   * multiply 乗算
   */
  @PostMapping("/multiply")
  public BigDecimal multiply(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラーがある場合はメッセージを返す
    Validation.validationRequest(result);

    // 正常な場合は、BigDecimal型に変換し計算結果を返す
    BigDecimal bigDecimalNum1 = BigDecimal.valueOf(request.getNum1());
    BigDecimal bigDecimalNum2 = BigDecimal.valueOf(request.getNum2());
    BigDecimal product = bigDecimalNum1.multiply(bigDecimalNum2);

    return product;
  }

  /**
   * divide 除算
   */
  @PostMapping("/divide")
  public int divide(@Valid @RequestBody NumJsonRequest request, BindingResult result) throws BindException {

    // 入力内容チェックし、エラーがある場合はメッセージを返す
    Validation.validationRequest(result);
    Validation.validationDivideRequest(request); // 除数0エラー

    // 正常な場合は計算結果を返す
    return request.getNum1() / request.getNum2();
  }

}
