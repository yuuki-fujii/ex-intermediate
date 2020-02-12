package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテルを検索する
 * 
 * @author yuuki
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテルを検索する.
	 * 
	 * @param price 価格
	 * @return　入力された価格以下のホテル情報
	 */
	public List<Hotel> searchHotel(Integer price){
		return hotelRepository.findByPrice(price);
	}
	
	
	/**
	 * ホテルの全件検索.
	 * 
	 * @return 全ホテルの情報
	 */
	public List<Hotel> getAllHotel(){
		return hotelRepository.findAll();
	}
}
