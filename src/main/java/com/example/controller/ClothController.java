package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.service.ClothService;

/**
 * 衣類情報の処理制御を行うコントローラ.
 * 
 * @author yuuki
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService clothService;
	
	/**
	 * 検索画面に遷移する.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String search() {
		return "/Ex03/search";
	}
	
	/**
	 * 検索結果を表示する.
	 * 
	 * @param form 衣類検索フォーム
	 * @param model　リクエストスコープ 
	 * @return 検索結果
	 */
	@RequestMapping("/result")
	public String result(ClothForm form, Model model) {
		Integer gender = form.getIntGender();
		String color = form.getColor();
		
		List <Cloth> clothList = clothService.searchCloth(gender, color);
		model.addAttribute("clothList", clothList);
		return "/Ex03/search";
	}
}
