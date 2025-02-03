package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Review {
	
	private Integer reviewId;
	private Integer regendsId;
	private String userName;
	private Integer age;
	private Date playDate;
	private Integer rating;
	private String comment;

}
