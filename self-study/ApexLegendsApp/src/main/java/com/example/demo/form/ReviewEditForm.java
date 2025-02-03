package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewEditForm {
	
	@NotNull(message="入力してください。")
	@Min(value=1, message="正の整数を入力してください。")
	private Integer reviewId;
	
	@NotNull(message="入力してください。")
	@Min(value=1, message="正の整数を入力してください。")
	private Integer regendsId;
	
	private String regendsName;
	
	@Size(min=1, max=10, message="1文字～10文字以内で入力してください。")
	private String userName;
	
	@NotNull(message="あなたの年齢を入力してください。")
	@Min(value=1, message="正の整数を入力してください。")
	private Integer age;
	
	@Past(message="今日以前の日付を入力してください。")
	private Date playDate;
	
	@NotNull(message="評価を指定してください。")
	@Min(value=1, message="1-10で指定してください。")
	@Max(value=10, message="1-10で指定してください。")
	private Integer rating;
	
	@Size(min=1, max=128, message="1文字～128文字以内で入力してください。")
	private String comment;	

}
