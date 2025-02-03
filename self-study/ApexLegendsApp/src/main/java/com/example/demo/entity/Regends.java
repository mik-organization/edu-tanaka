package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regends {
	
	private int regendsId;
	private String regendsName;
	private String regendsClass;
	private double averageRating;  //平均評価（1.0 - 10.0 )
								   //0.0はレビューなし
	
	
	//平均評価表示
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
