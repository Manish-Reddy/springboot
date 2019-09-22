package com.soccer.control.service;

import java.util.List;

import com.soccer.entity.SoccerBoard;

public interface IScoreService {

	public String getScoreService();

	public SoccerBoard fetchScoreByTitleService(String title);

	public Boolean deleteSocreByTitleService(String title);

	public List<SoccerBoard> fetchAllService();

	public Boolean updateScoreByTitleService(SoccerBoard soccer);

	public Boolean deleteAllService();

}
