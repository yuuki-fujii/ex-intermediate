package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * teamsテーブルにアクセスするためのリポジトリ.
 * 
 * @author yuuki
 *
 */
@Repository
public class BaseballTeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * BaseballTeamクラスオブジェクトを生成するRowMapper.
	 */
	private static final RowMapper<BaseballTeam> BASEBALLTEAM_ROW_MAPPER
		= (rs, i) ->{
			BaseballTeam team = new BaseballTeam();
			team.setId(rs.getInt("id"));
			team.setLeagueName(rs.getString("league_name"));
			team.setTeamName(rs.getString("team_name"));
			team.setHeadquarters(rs.getString("headquarters"));
			team.setInauguration(rs.getString("inauguration"));
			team.setHistory(rs.getString("history"));
			return team;
		};
	
	/**
	 * 全球団の情報を取得する.
	 * 
	 * @return 全球団の情報
	 */
	public List<BaseballTeam> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history " 
					+"FROM teams ORDER BY inauguration";
		
		List <BaseballTeam> teamList = template.query(sql, BASEBALLTEAM_ROW_MAPPER); 
		return teamList;
	}
	
	/**
	 * idから球団の詳細情報を取得するメソッド.
	 * 
	 * @param id 主キー
	 * @return　球団の詳細情報
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
					+"FROM teams WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam team = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);
		return team;
	}
}
