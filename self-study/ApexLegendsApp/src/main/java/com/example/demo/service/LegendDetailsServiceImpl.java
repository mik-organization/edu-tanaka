package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;
import com.example.demo.repository.LegendDetailsRepository;

import lombok.RequiredArgsConstructor;

/** レジェンド詳細表示用のserviceクラス */
@Repository
@RequiredArgsConstructor
public class LegendDetailsServiceImpl implements LegendDetailsService {

  private final LegendDetailsRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param legendId
   * @return repositoryクラスから返されたリスト
   */
  @Override
  public List<Details> findByLegendId(int legendId) {

    List<Details> list = repository.selectByLegendId(legendId);

    return list;
  }
}
