package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Legend;

/** レジェンドのデータベース操作処理を行うリポジトリクラス */
public interface LegendApiRepository extends JpaRepository<Legend, Integer> {}
