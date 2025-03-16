package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Legend;
import com.example.demo.repository.LegendRepository;

import lombok.RequiredArgsConstructor;

/** レジェンド検索処理用のserviceクラス */
@Service
@RequiredArgsConstructor
public class LegendListServiceImpl implements LegendListService {

  private final LegendRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param name
   * @return repositoryクラスから渡されたリスト
   */
  @Override
  public List<Legend> findByNamecard(String name) {

    List<Legend> list = repository.selectByNameWildcard(name);

    return list;
  }
}
