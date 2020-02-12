package com.example.service;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.BaseballTeam;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballTeamServiceTest {

	@Autowired
	private BaseballTeamService baseballTeamService;
	
	@Test
	public void testShowList() {
		System.out.println("全件検索するテスト開始");
		
		List <BaseballTeam> teamList = baseballTeamService.showList();
		
		assertThat("チーム数が一致しません",teamList.size(),comparesEqualTo(6));
		assertThat("発足日順に並んでいません",teamList.get(0).getTeamName(),comparesEqualTo("読売ジャイアンツ"));
		assertThat("発足日順に並んでいません",teamList.get(5).getTeamName(),comparesEqualTo("東京ヤクルトスワローズ"));
		
		System.out.println("全件検索するテスト終了");
	}
	
	@Test
	public void testShowDetail() {
		System.out.println("詳細ページのテスト開始");
		
		BaseballTeam team = baseballTeamService.showDetail(1);
		assertThat("チーム名が違います",team.getTeamName(),comparesEqualTo("読売ジャイアンツ"));
		assertThat("本拠地が違います",team.getHeadquarters(),comparesEqualTo("東京ドーム（東京都・文京区）"));
		assertThat("発足日が違います",team.getInauguration(),comparesEqualTo("1934年12月26日"));
			
		System.out.println("詳細ページのテスト終了");
	}
	
}
