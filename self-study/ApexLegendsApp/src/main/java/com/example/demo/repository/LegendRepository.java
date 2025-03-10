package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Legend;

public interface LegendRepository {
	
	List<Legend>selectByNameWildcard(String name);

}
