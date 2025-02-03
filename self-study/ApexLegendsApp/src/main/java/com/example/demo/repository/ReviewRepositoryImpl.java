package com.example.demo.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void add(Review review) {
		
		String sql =
				"INSERT INTO t_review" +
				"(regends_id, user_name, age, play_date, rating, comment)" +
				"VALUES(?, ?, ?, ?, ?, ? )";
		
		jdbcTemplate.update(sql, review.getRegendsId(),
								 review.getUserName(),
								 review.getAge(),
								 review.getPlayDate(),
								 review.getRating(),
								 review.getComment()      );		

	}

	@Override
	public List<Review> selectByRegendsId(int regendsId) {
		
		String sql =
				"SELECT									" +
				"	review_id,							" +
				"	regends_id,							" +
				"	user_name,							" +
				"	age,								" +
				"	play_date,							" +
				"	rating,								" +
				"	comment								" +
				"FROM									" +
				"	t_review							" +
				"WHERE									" +
				"	regends_id = ?						" +
				"ORDER BY								" +
				"	play_date DESC,						" +
				"	review_id ASC						";
		
		
		//SQLで検索（プレースホルダ：引数で受け取ってregendsId）
		List<Map<String, Object>> list
			=jdbcTemplate.queryForList(sql, regendsId);
		
		
		//値の取得⇒結果の格納
		List<Review> result = new ArrayList<Review>();		//結果の初期化
		for (Map<String,Object> one : list) {
			Review review = new Review();
			review.setReviewId((int)one.get("review_id"));
			review.setRegendsId((int)one.get("regends_id"));
			review.setUserName((String)one.get("user_name"));
			review.setAge((int)one.get("age"));
			review.setPlayDate((Date)one.get("play_date"));
			review.setRating((int)one.get("rating"));
			review.setComment((String)one.get("comment"));
			result.add(review);
			
		}
				
				
		return result;
	}

	@Override
	public void update(Review review) {
		
		String sql =
				"UPDATE               " +
				"	t_review		  " +
				"SET				  " +
				"	user_name = ?,	  " +
				"	age	= ?,		  " +
				"	play_date = ?,    " +
				"	rating = ?,		  " +
				"   comment = ?       " +
				"WHERE				  " +
				"	review_id = ?	  "; 
		
		jdbcTemplate.update(sql,
				review.getUserName(),
				review.getAge(),
				review.getPlayDate(),
				review.getRating(),
				review.getComment(),
				review.getReviewId()	);
	}

	@Override
	public void delete(Review review) {
		
		String sql =
				"DELETE				" +
				"FROM				" +
				"	t_review		" +
				"WHERE				" +
				"	review_id = ?	";
		
		jdbcTemplate.update(sql, review.getReviewId());
		
	}

}
