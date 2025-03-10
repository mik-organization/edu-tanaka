package com.example.demo.entity;

import lombok.Data;

/** レジェンド詳細表示用のentityクラス */
@Data
public class Details {

  private int id;
  private String name;
  private String words;
  private String picturePath;
  private String realName;
  private int age;
  private String ageNote;
  private String gender;
  private String abilities;
  private String abiDescription;
  private String passive;
  private String pasDescripition;
  private String ult;
  private String ultDescripition;
}
