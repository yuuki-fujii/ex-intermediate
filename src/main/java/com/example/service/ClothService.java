package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣類を検索する.
 * 
 * @author yuuki
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository clothRepository;
	
	/**
	 * 衣類を検索するメソッド.
	 * 
	 * @param gender　性別
	 * @param color　色
	 * @return　検索結果に該当する衣類のデータ
	 */
	public List<Cloth> searchCloth(Integer gender, String color){
		return clothRepository.findByGenderAndColor(gender, color);
	}
	
}
