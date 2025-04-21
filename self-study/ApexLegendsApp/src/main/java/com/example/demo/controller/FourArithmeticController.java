package com.example.demo.controller;

import java.math.BigDecimal;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.request.CalcRequest;
import com.example.demo.model.request.DivideRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/calc")
@RequiredArgsConstructor
@Validated
public class FourArithmeticController {

  /** 和を返す */
  @PostMapping("/add")
  public int add(@Valid @RequestBody CalcRequest request) {

    return request.getNum1() + request.getNum2();
  }

  /** 差を返す */
  @PostMapping("/subtract")
  public int subtract(@Valid @RequestBody CalcRequest request) {

    return request.getNum1() - request.getNum2();
  }

  /** 積を返す */
  @PostMapping("/multiply")
  public BigDecimal multiply(@Valid @RequestBody CalcRequest request) {

    BigDecimal bigDecimalNum1 = BigDecimal.valueOf(request.getNum1());
    BigDecimal bigDecimalNum2 = BigDecimal.valueOf(request.getNum2());

    return bigDecimalNum1.multiply(bigDecimalNum2);
  }

  /** 商を返す */
  @PostMapping("/divide")
  public int divide(@Valid @RequestBody DivideRequest request) {

    return request.getNum1() / request.getNum2();
  }
}
