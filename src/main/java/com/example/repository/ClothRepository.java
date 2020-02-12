package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * clothesテーブルにアクセスするためのリポジトリ.
 * 
 * @author yuuki
 *
 */
@Repository
public class ClothRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Clothクラスオブジェクトを生成するRowMapper.
	 */
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER
		= (rs, i)->{
			Cloth cloth = new Cloth();
			cloth.setId(rs.getInt("id"));
			cloth.setCategory(rs.getString("category"));
			cloth.setGenre(rs.getString("genre"));
			cloth.setGender(rs.getInt("gender"));
			cloth.setColor(rs.getString("color"));
			cloth.setPrice(rs.getInt("price"));
			cloth.setSize(rs.getString("size"));
			return cloth;
		};
	
		
	/**
	 * 性別と色を基に衣類を検索する.
	 * 
	 * @return 検索の結果該当した衣類情報のリスト
	 */
	public List<Cloth> findByGenderAndColor(Integer gender, String color){
		String sql = "SELECT id, category, genre, gender, color, price, size " +
					 "FROM clothes WHERE gender=:gender AND color=:color ";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
	
		return clothList;
	}
}
