package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

/**
 * レビュー削除用のserviceクラス
 */
@Service
@RequiredArgsConstructor
public class RemoveServiceImpl implements RemoveService {
	
	private final ReviewRepository repository;

	/**
	 *repositoryクラスへのアクセス
	 *@param review
	 */
	@Override
	public void remove(Review review) {
		
		repository.delete(review);

	}

}
