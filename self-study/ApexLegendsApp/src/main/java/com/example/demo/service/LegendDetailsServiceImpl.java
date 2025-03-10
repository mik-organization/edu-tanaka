package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;
import com.example.demo.repository.LegendDetailsRepository;

import lombok.RequiredArgsConstructor;

/**
 * LegendDetailsServiceを実装するクラス
 */
@Repository
@RequiredArgsConstructor
public class LegendDetailsServiceImpl implements LegendDetailsService {
	
	private final LegendDetailsRepository repository;
	


	/**
	 *
	 */
	@Override
	public List<Details> findById(int id) {
	
		List<Details> list
			=repository.selectById(id);
		
		return list;
	}

}
