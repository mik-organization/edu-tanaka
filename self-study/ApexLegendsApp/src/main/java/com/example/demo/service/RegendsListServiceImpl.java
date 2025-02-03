package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Regends;
import com.example.demo.repository.RegendsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegendsListServiceImpl implements RegendsListService {
	
	private final RegendsRepository repository;

	@Override
	public List<Regends> findByNamecard(String regendsName) {
		
		List<Regends> list
			=repository.selectByNameWildcard(regendsName);
		
		return list;
	}

}
