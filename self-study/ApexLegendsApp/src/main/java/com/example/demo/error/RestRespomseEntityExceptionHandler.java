package com.example.demo.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestRespomseEntityExceptionHandler  extends ResponseEntityExceptionHandler{

  @ExceptionHandler(value = { NotFoundException.class, BadRequestException.class })
  protected ResponseEntity<Object> handleErrorResponseException(HttpException ex, WebRequest request) {
	  ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getHttpStatus());
	  
	  return this.handleErrorExceptionnternal(ex, errorResponse, new HttpHeaders(), ex.getHttpStatus(),request);
  }

}
