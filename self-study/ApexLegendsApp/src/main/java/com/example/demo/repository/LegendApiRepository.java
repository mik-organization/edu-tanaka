package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Legend;

/** レジェンドのデータベース操作処理を行うリポジトリクラス */
public interface LegendApiRepository extends JpaRepository<Legend, Integer> {
	
	List<Legend> findByNameContaining(String name); // レジェンド名の部分検索
	
	
}
