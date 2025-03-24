package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LegendApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LegendApiService {
	  
	  private final LegendApiRepository repository;
	  
	  public LegendApi findById(Integer id) {
		  return repository.findById(id);
	  }
    
	  public LegendApi add(String name, String realName ) {
		  
	  }
	  
	  public LegendApi update(Integer id, String name) {
		  var v = new LegendApi(Integer id, String Name);
		  repository.update(v);
		  return v;
	  }
	  
	  public LegendApi delete(Integer id) {
		  repository.delete(id);
		  return findById(id);
	  }
}
