package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Details;

public interface RegendsDetailsRepository {
	
	List<Details> selectByRegendsId(int regendsId);
	

}
