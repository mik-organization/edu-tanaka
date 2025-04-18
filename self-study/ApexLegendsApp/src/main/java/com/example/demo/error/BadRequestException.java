package com.example.demo.error;

public class  BadRequestException extends RuntimeException{

  /**
   * 
   */
  public BadRequestException() {
    super();

  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public BadRequestException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message,cause,enableSuppression,writableStackTrace);

  }

  /**
   * @param message
   * @param cause
   */
  public BadRequestException(String message, Throwable cause) {
    super(message,cause);

  }

  /**
   * @param message
   */
  public BadRequestException(String message) {
    super(message);

  }

  /**
   * @param cause
   */
  public BadRequestException(Throwable cause) {
    super(cause);

  }


}
