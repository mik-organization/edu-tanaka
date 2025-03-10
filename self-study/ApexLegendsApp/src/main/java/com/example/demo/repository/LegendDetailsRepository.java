package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Details;

/** レジェンドの詳細情報を選択するインタフェース */
public interface LegendDetailsRepository {

  List<Details> selectById(int id);
}
