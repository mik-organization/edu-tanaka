package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.Data;

/** レビュー削除用のformクラス */
@Data
public class ReviewRemoveForm {

  private Integer id;

  private Integer legendId;

  private String name;

  @NotNull(message = "入力してください。")
  @Size(max = 10, message = "10文字以内で入力してください。")
  private String userName;

  @Min(value = 1, message = "正の整数を入力してください。")
  private Integer age;

  @Past(message = "今日以前の日付を入力してください。")
  private Date playDate;

  @NotNull(message = "評価を指定してください。")
  @Min(value = 1, message = "1-10で指定してください。")
  @Max(value = 10, message = "1-10で指定してください。")
  private Integer rating;

  @Size(max = 128, message = "128文字以内で入力してください。")
  private String comment;
}
