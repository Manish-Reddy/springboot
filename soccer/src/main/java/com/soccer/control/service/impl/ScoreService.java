package com.soccer.control.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.soccer.control.service.IScoreService;
import com.soccer.entity.Competition;
import com.soccer.entity.SoccerBoard;
import com.soccer.entity.Teams;

@Service
public class ScoreService implements IScoreService {
	@Value("${soccer.url}")
	private String soccerUrl;
	// List to store Data
	List<SoccerBoard> list = new ArrayList<SoccerBoard>();

	public String getScoreService() {
		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(soccerUrl, String.class);

		// JSON
		JSONArray jsonArray = new JSONArray(result);
		JSONObject jsonObj;
		
		// declarations
		SoccerBoard soccer;
		Teams team1, team2;
		Competition competition;

		for (int i = 0; i < jsonArray.length(); i++) {
			// JSON object
			jsonObj = new JSONObject();
			jsonObj = jsonArray.getJSONObject(i);
			// SoccerBoard object
			soccer = new SoccerBoard();
			team1 = new Teams();
			team2 = new Teams();
			competition = new Competition();
			
			// SoccerBoard
			soccer.setTitle(jsonObj.getString("title"));
			soccer.setEmbed(jsonObj.getString("embed"));
			soccer.setUrl(jsonObj.getString("url"));
			soccer.setThumbnail(jsonObj.getString("thumbnail"));
			soccer.setDate(jsonObj.getString("date"));
			// get side1
			team1.setName(jsonObj.getJSONObject("side1").getString("name"));
			team1.setUrl(jsonObj.getJSONObject("side1").getString("url"));
			soccer.setSide1(team1);
			// get side2
			team2.setName(jsonObj.getJSONObject("side2").getString("name"));
			team2.setUrl(jsonObj.getJSONObject("side2").getString("url"));
			soccer.setSide2(team2);
			// get competition
			competition.setName(jsonObj.getJSONObject("competition").getString("name"));
			competition.setId(jsonObj.getJSONObject("competition").getInt("id"));
			competition.setUrl(jsonObj.getJSONObject("competition").getString("url"));
			soccer.setCompetition(competition);
			/* soccer.setVideos(jsonObj.getString("videos")); */

			list.add(soccer);
		}

		return result;
	}

	public SoccerBoard fetchScoreByTitleService(String title) {
		SoccerBoard result = new SoccerBoard();
		for (SoccerBoard soccer : list) {
			if (title.equals(soccer.getTitle())) {
				result = soccer;
				break;
			}
		}
		return result;
	}

	public Boolean deleteSocreByTitleService(String title) {
		Boolean flag = false;
		for (SoccerBoard soccer : list) {
			if (title.equals(soccer.getTitle())) {
				list.remove(soccer);
				flag = true;
				break;
			}
		}
		return flag;
	}

	public List<SoccerBoard> fetchAllService() {
		return list;
	}

	public Boolean updateScoreByTitleService(SoccerBoard soccer) {
		Boolean flag = false;
		for (SoccerBoard board : list) {
			System.out.println("soccer.getTitle() => " + board.getTitle());
			if (board.getTitle().equals(soccer.getTitle())) {
				list.set(list.indexOf(board), soccer);
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Boolean deleteAllService() {
		return list.removeAll(list);
	}

}
