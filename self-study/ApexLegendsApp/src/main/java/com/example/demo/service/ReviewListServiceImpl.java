package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

/** レビュー表示用のserviceクラス */
@Service
@RequiredArgsConstructor
public class ReviewListServiceImpl implements ReviewListService {

  private final ReviewRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param legendId
   * @return repositoryクラスから返されたリスト *
   */
  @Override
  public List<Review> findByLegendId(int legendId) {

    List<Review> list = repository.selectByLegendId(legendId);

    return list;
  }
}
