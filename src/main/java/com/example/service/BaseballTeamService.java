package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

/**
 * 野球チームの情報の取得を行う.
 * 
 * @author yuuki
 *
 */
@Service
@Transactional
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository baseballTeamRepository;
	
	
	/**
	 * 各球団の情報一覧.
	 * 
	 * @return 各球団の情報リスト
	 */
	public List<BaseballTeam> showList (){
		return baseballTeamRepository.findAll();
	}
	
	/**
	 * 1球団の詳細情報を取得
	 * 
	 * @param id　主キー
	 * @return BaseballTeamオブジェクト
	 */
	public BaseballTeam showDetail(Integer id) {
		return baseballTeamRepository.load(id);
	}
	
}
