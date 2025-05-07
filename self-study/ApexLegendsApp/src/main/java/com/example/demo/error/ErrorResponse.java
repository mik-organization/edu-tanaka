package com.example.demo.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** APIエラーのレスポンスを表現するためのクラス */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

  private String message;
  private HttpStatus status;
}
