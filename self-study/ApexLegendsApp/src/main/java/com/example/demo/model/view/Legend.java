package com.example.demo.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** レジェンド一覧表示用のentityクラス */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Legend {

  private int legendId;
  private String name;
  private String legendClass;
  private double averageRating;

  /**
   * レビュー平均評価算出設定（1.0 - 10.0 )
   *
   * @return 結果
   */
  public String formatAverageRating() {
    String result;

    if (averageRating == 0.0) {
      result = "-";
    } else {
      result = String.format("%.1f", averageRating);
    }

    return result;
  }
}
