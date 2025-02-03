package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Regends;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegendsRepositoryImpl implements RegendsRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Regends> selectByNameWildcard(String regendsName) {
		
		String sql =                                             
				"SELECT											   " +
				"	mx.regends_id,								   " +
				"	mx.regends_name,							   " +		
				"	mx.regends_class,							   " +
				"	COALESCE(AVG(tr.rating), 0.0 ) average_rating  " +
				"FROM											   " +
				"	m_apex mx								   " +
				"	LEFT OUTER JOIN t_review tr					   " +
				" 				 ON mx.regends_id = tr.regends_id  " +
				"WHERE											   " +
				"	mx.regends_name LIKE ?						   " +
				"GROUP BY										   " +
				"	mx.regends_id,								   " +
				"	mx.regends_name,							   " +
				"	mx.regends_class							   " +
				"ORDER BY										   " +
				"	mx.regends_id								   " ;
		
		String p = "%" + regendsName + "%";				//プレースホルダの値
		
		//SQLで検索（プレースホルダ：p）
		List<Map<String, Object>> list
			=jdbcTemplate.queryForList(sql, p);
		
		//値の取得⇒結果の格納
		List<Regends> result = new ArrayList<Regends>();   //結果の初期化
		for (Map<String, Object> one : list) {
			Regends regends = new Regends();
			regends.setRegendsId((int)one.get("regends_id"));
			regends.setRegendsName((String)one.get("regends_name"));
			regends.setRegendsClass((String)one.get("regends_class"));
			double d = ((BigDecimal)one.get("average_rating")).doubleValue();
			regends.setAverageRating(d);
			result.add(regends);
		}
		
		return result;
	}

}
