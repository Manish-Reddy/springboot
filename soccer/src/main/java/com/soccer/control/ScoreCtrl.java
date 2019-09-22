package com.soccer.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soccer.control.service.IScoreService;
import com.soccer.entity.SoccerBoard;

@RestController
@RequestMapping("scorectrl")
public class ScoreCtrl {
	@Autowired
	IScoreService scoreService;
	
	@RequestMapping(value = "/getscoreurl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getScoreCtrl() {
		String result = scoreService.getScoreService();
		return result;
	}
	
	@RequestMapping(value = "/fetchscorebytitle",method = RequestMethod.POST,consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SoccerBoard fetchScoreByTitleCtrl(@RequestParam String title) {
		SoccerBoard result = scoreService.fetchScoreByTitleService(title);
		return result;
	}
	
	@RequestMapping(value = "/deletesocrebytitle",method = RequestMethod.DELETE,consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean deleteSocreByTitleCtrl(@RequestParam String title) {
		Boolean result = scoreService.deleteSocreByTitleService(title);
		return result;
	}
	
	@RequestMapping(value = "/fetchAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<SoccerBoard> fetchAllCtrl(){
		List<SoccerBoard> result = scoreService.fetchAllService();
		return result;
	}
	
	@RequestMapping(value = "updatescorebytitle",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean updateScoreByTitleCtrl(@RequestBody SoccerBoard soccer) {
		Boolean result = scoreService.updateScoreByTitleService(soccer);
		return result;
	}
	
	@RequestMapping(value = "deleteAll",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean deleteAllCtrl() {
		Boolean result = scoreService.deleteAllService();
		return result;
	}

}
