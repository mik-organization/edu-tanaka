package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Legend;

/**
 * 
 */
public interface LegendListService {
	
	/**
	 * @param name
	 * @return
	 */
	List<Legend>findByNamecard(String name);

}
