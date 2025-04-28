package com.example.demo.error;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** REST APIにおけるバリデーション例外を処理する例外ハンドラー */
@ControllerAdvice
public class RestRespomseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * 　アノテーションによるバリデーション失敗時の例外を処理します。
   *
   * @param ex バリデーションエラー時にスローされる例外
   * @param headers HTTP ヘッダー情報
   * @param status HTTP ステータスコード
   * @param request リクエスト情報
   * @return handleExceptionInternal エラーメッセージ、ステータスコードを含んだResponseEntity
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    BindingResult bindingResult = ex.getBindingResult();
    List<FieldError> fieldError = bindingResult.getFieldErrors();

    String errorMsg =
        fieldError.stream()
            .map(error -> error.getDefaultMessage())
            .reduce((msg1, msg2) -> msg1 + " / " + msg2)
            .orElse("validationエラーが発生しました。");

    ErrorResponse errorResponse = new ErrorResponse(errorMsg, HttpStatus.BAD_REQUEST);

    return this.handleExceptionInternal(
        ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
