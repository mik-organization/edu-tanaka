package com.example.demo.controller.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.example.demo.controller.validator.annotation.DivideValidation;
import com.example.demo.model.request.DivideRequest;

/** DivideValidationの検証ロジックを実装するバリデータークラス */
@Component
public class DivideValidator implements ConstraintValidator<DivideValidation, DivideRequest> {

  /** DivideRequestのnum2が0かどうかを検証します。 */
  @Override
  public boolean isValid(DivideRequest value, ConstraintValidatorContext context) {
    if (value == null || value.getNum2() == null) {
      return true;
    }

    if (value.getNum2() == 0) {
      context.disableDefaultConstraintViolation();
      context
          .buildConstraintViolationWithTemplate("除数（num2）は0にできません。")
          .addPropertyNode("num2")
          .addConstraintViolation();

      return false;
    }
    return true;
  }
}
