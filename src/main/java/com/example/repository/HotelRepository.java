package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルにアクセスするためのリポジトリ.
 * 
 * @author yuuki
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Hotelクラスオブジェクトを生成するRowMapper.
	 */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
		= (rs, i) ->{
			Hotel hotel = new Hotel();
			hotel.setId(rs.getInt("id"));
			hotel.setHotelName(rs.getString("hotel_name"));
			hotel.setNearestStation(rs.getString("nearest_station"));
			hotel.setPrice(rs.getInt("price"));
			return hotel;
		};
	
		
	/**　
	 * ホテルを検索する
	 * 
	 * @param price 価格　
	 * @return　入力された価格以下のホテル情報
	 */
	public List<Hotel> findByPrice(Integer price){
		String sql = "SELECT id, hotel_name, nearest_station, price FROM hotels "
					+"WHERE price <= :price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	
	/**
	 * 全ホテルの情報を取得する
	 * 
	 * @return 全ホテルの情報
	 */
	public List<Hotel> findAll(){
		String sql = "SELECT id, hotel_name, nearest_station, price FROM hotels ";
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
}
