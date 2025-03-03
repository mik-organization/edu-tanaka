package com.example.demo.controller.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JSONでリクエストを受け取る
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumJsonRequest {
  @NotNull(message = "num1は必須です。")
  @Min(value = -999999999, message = "num1は1～9桁の数字で入力してください。")
  @Max(value = 999999999, message = "num1は1～9桁の数字で入力してください。")
  private Integer num1;

  @NotNull(message = "num2は必須です。")
  @Min(value = -999999999, message = "num2は1～9桁の数字で入力してください。")
  @Max(value = 999999999, message = "num2は1～9桁の数字で入力してください。")
  private Integer num2;

}
