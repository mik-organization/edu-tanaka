package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegendsDetailsRepositoryImpl implements RegendsDetailsRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Details> selectByRegendsId(int regendsId) {
		
		String sql =
				"SELECT									" +
				"	regends_id,							" +
				"	regends_name,						" +
				"	words,								" +
				"	picture_path,						" +
				"	real_name,							" +
				"	age,								" +
				"	gender,								" +
				"	abilities,							" +
				"	abi_description,						" +
				"	passive,							" +
				"	pas_description,					" +
				"	ult,								" +
				"	ult_description						" +
				"FROM									" +
				"	m_apex								" +
				"WHERE									" +
				"	regends_id = ?						";
		//SQLで検索
		List<Map<String,Object>> list
			=jdbcTemplate.queryForList(sql, regendsId);
		
		//値の取得⇒結果の格納
		List<Details> result = new ArrayList<Details>();
		for (Map<String, Object> one : list) {
			Details details = new Details();
			details.setRegendsId((int)one.get("regends_id"));
			details.setRegendsName((String)one.get("regends_name"));
			details.setWords((String)one.get("words"));
			details.setPicturePath((String)one.get("picture_path"));
			details.setRealName((String)one.get("real_name"));
			details.setAge((String)one.get("age"));
			details.setGender((String)one.get("gender"));
			details.setAbilities((String)one.get("abilities"));
			details.setAbiDescription((String)one.get("abi_description"));
			details.setPassive((String)one.get("passive"));
			details.setPasDescripition((String)one.get("pas_description"));
			details.setUlt((String)one.get("ult"));
			details.setUltDescripition((String)one.get("ult_description"));
			result.add(details);
			
		}
		
		return result;
	}

}
