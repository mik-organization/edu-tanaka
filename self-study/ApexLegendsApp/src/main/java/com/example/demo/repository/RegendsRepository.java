package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Regends;

public interface RegendsRepository {
	
	List<Regends>selectByNameWildcard(String regendsName);

}
