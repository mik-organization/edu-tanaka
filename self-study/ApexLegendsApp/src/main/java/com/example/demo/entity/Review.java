package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

/** レビュー一覧表示用のentityクラス */
@Data
public class Review {

  private Integer id;
  private Integer legendId;
  private String userName;
  private Integer age;
  private Date playDate;
  private Integer rating;
  private String comment;
}
