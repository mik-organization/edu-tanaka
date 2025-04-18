package com.example.demo.controller.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.example.demo.controller.validator.DivideValidator;

/** 除数（num2）が0かを検証するアノーテーションを作成 */
@Documented
@Constraint(validatedBy = DivideValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DivideValidation {

  String message() default "除数（num2）は0にはできません。";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
