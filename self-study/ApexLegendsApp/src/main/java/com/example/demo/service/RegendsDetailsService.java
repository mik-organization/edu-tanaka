package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Details;

public interface RegendsDetailsService {
	
	List<Details> findByRegendsId(int regendsId);

}
