package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテル情報の処理制御を行うコントローラ.
 * 
 * @author yuuki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	/**
	 * ホテル検索画面に遷移.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String search() {
		return "/Ex02/search";
	}
	
	
	/**
	 * 検索結果を表示.
	 * 
	 * @param form 検索フォーム
	 * @param model　リクエストスコープ
	 * @return　検索結果
	 */
	@RequestMapping("/result")
	public String result(HotelForm form, Model model) {
		if (form.getPrice().isEmpty()) {
			List <Hotel> hotelList = hotelService.getAllHotel();
			model.addAttribute("hotelList", hotelList);
		} else {
			List <Hotel> hotelList = hotelService.searchHotel(form.getIntPrice());
			model.addAttribute("hotelList", hotelList);
		}
		return "/Ex02/search";
	}
	
}
