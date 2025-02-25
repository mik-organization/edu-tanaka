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
  @Min(value = -2147483647, message = "-2147483647以上を指定してください。")
  @Max(value = 2147483647, message = "2147483647以下を指定してください。")
  public Integer num1;

  @NotNull(message = "num2は必須です。")
  @Min(value = -2147483647, message = "-2147483647以上を指定してください。")
  @Max(value = 2147483647, message = "2147483647以下を指定してください。")
  public Integer num2;

}
