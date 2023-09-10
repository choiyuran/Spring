package com.itbank.model;
/*
	IDX          NUMBER      
	TITLE        VARCHAR2(500)  
	CHANNEL      VARCHAR2(100)  
	VIEWCOUNT    NUMBER         
	THUMBNAIL    VARCHAR2(500)  
	MOVIETAG     VARCHAR2(1000)
*/ 

public class YoutubeDTO {
	private int idx;
	private String title;
	private String channel;
	private int viewCount;
	private String thumbnail;
	private String movieTag;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getMovieTag() {
		return movieTag;
	}
	public void setMovieTag(String movieTag) {
		this.movieTag = movieTag;
	}
	
	
}
