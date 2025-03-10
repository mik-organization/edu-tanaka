package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Review;

public interface ReviewRepository {
	
	void add(Review review);
	
	List<Review>selectByLegendId(int legendId);
	
	void update(Review review);
	
	void delete(Review review);

}
