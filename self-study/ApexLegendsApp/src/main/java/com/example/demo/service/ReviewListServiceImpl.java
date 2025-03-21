package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.view.Review;
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
   * @return reviewに格納したList
   */
  @Override
  public List<Review> findByLegendId(int legendId) {

    List<Map<String, Object>> list = repository.selectByLegendId(legendId);

    List<Review> result = new ArrayList<Review>();
    for (Map<String, Object> one : list) {
      Review review = new Review();
      review.setId((int) one.get("id"));
      review.setLegendId((int) one.get("legend_id"));
      review.setUserName((String) one.get("user_name"));
      review.setAge((Integer) one.get("age"));
      review.setPlayDate((Date) one.get("play_date"));
      review.setRating((Integer) one.get("rating"));
      review.setComment((String) one.get("comment"));
      result.add(review);
    }

    return result;
  }
}
