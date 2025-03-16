package com.example.demo.service;

import com.example.demo.entity.Review;

/**
 * レビュー削除用のserviceクラス
 */
public interface RemoveService {
	
	/**
	 * レビュー削除処理の型定義
	 * @param review
	 */
	void remove(Review review);

}
