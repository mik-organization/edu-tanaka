package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.view.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

/** レビュー登録用のserviceクラス */
@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

  private final ReviewRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param review
   */
  @Override
  public void regist(Review review) {
    repository.add(review);
  }
}
