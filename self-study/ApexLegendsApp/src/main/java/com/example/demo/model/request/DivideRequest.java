package com.example.demo.model.request;

import com.example.demo.controller.validator.annotation.DivideValidation;

/** 除算専用の数値格納リクエストモデル */
@DivideValidation
public class DivideRequest extends CalcRequest {

  /**
   * 親クラスのコンストラクタを呼び出し,、除数用のリクエストを初期化します。
   *
   * @param num1 被除数
   * @param num2 除数
   */
  public DivideRequest(Integer num1, Integer num2) {
    super(num1, num2);
  }
}
