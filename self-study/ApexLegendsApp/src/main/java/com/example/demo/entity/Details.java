package com.example.demo.entity;

import lombok.Data;

/** レジェンド詳細表示用のentityクラス */
@Data
public class Details {

  private int legendId;
  private String name;
  private String words;
  private String picturePath;
  private String realName;
  private Integer age;
  private String ageNote;
  private String gender;
  private String abilities;
  private String abiDescription;
  private String passive;
  private String pasDescripition;
  private String ult;
  private String ultDescripition;
  private int sortIndex;

  /**
   * ageの設定
   *
   * @return　結果
   */
  public String ageStr() {
    String result;

    if (ageNote == null) {
      ageNote = "";
    }

    if (age == null) {
      result = "不明";
    } else {
      result = age + "歳" + ageNote;
    }
    return result;
  }
}
