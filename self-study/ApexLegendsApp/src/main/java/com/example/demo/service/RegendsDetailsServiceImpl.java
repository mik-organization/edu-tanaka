package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;
import com.example.demo.repository.RegendsDetailsRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegendsDetailsServiceImpl implements RegendsDetailsService {
	
	private final RegendsDetailsRepository repository;
	

	@Override
	public List<Details> findByRegendsId(int regendsId) {
	
		List<Details> list
			=repository.selectByRegendsId(regendsId);
		
		return list;
	}

}
