package com.example.demo.error;


  public class  NotFoundException extends RuntimeException{

  /**
   * 
   */
  public NotFoundException() {
    super();

  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public NotFoundException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message,cause,enableSuppression,writableStackTrace);

  }

  /**
   * @param message
   * @param cause
   */
  public NotFoundException(String message, Throwable cause) {
    super(message,cause);

  }

  /**
   * @param message
   */
  public NotFoundException(String message) {
    super(message);

  }

  /**
   * @param cause
   */
  public NotFoundException(Throwable cause) {
    super(cause);

  }
	  
 
}
