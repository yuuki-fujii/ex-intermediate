package com.example.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * 
 * 球団情報の処理制御を行うコントローラ.
 * @author yuuki
 *
 */
@Controller
@RequestMapping("/baseball-team")
public class BaseballTeamController {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private BaseballTeamService baseballTeamService;
	
	/**
	 * 野球チーム一覧ページに遷移.
	 * 
	 * @param model アプロケーションスコープ
	 * @return　野球チーム一覧ページ
	 */
	@RequestMapping("")
	public String index() {
		List <BaseballTeam> teamList = baseballTeamService.showList();
		application.setAttribute("teamList", teamList);
		return "/Ex01/index";
	}
	
	/**
	 * 球団詳細情報ページに遷移
	 * 
	 * @param id　主キー
	 * @param model リクエストスコープ
	 * @return　球団詳細情報ページ
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		BaseballTeam team = baseballTeamService.showDetail(id);
		model.addAttribute("team", team);
		return "/Ex01/detail";
	}
	
}
