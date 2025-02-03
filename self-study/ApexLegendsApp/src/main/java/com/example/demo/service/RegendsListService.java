package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Regends;

public interface RegendsListService {
	
	List<Regends>findByNamecard(String regendsName);

}
