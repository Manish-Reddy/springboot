package com.soccer.entity;


public class SoccerBoard {

	/* private Integer id; */
	private String title;
	private String embed;
	private String url;
	private String thumbnail;
	private String date;
	private Teams side1;
	private Teams side2;
	private Competition competition;
	/* private String videos; */

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmbed() {
		return embed;
	}

	public void setEmbed(String embed) {
		this.embed = embed;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Teams getSide1() {
		return side1;
	}

	public void setSide1(Teams side1) {
		this.side1 = side1;
	}

	public Teams getSide2() {
		return side2;
	}

	public void setSide2(Teams side2) {
		this.side2 = side2;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/*
	 * public String getVideos() { return videos; }
	 * 
	 * public void setVideos(String videos) { this.videos = videos; }
	 */
	
}
