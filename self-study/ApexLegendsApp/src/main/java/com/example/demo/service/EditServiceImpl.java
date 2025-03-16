package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

/** レビュー編集用のserviceクラス */
@Service
@RequiredArgsConstructor
public class EditServiceImpl implements EditService {

  private final ReviewRepository repository;

  /**
   * repositoryクラスへのアクセス
   *
   * @param legendId
   */
  @Override
  public void edit(Review review) {

    repository.update(review);
  }
}
