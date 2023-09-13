package com.itbank.model;

import java.sql.Date;

/*
	IDX       NOT NULL NUMBER        
	TITLE     NOT NULL VARCHAR2(100) 
	WRITER    NOT NULL VARCHAR2(50)  
	PASSWORD  NOT NULL VARCHAR2(50)  
	CONTENT   NOT NULL CLOB          
	VIEWCOUNT          NUMBER        
	WDATE              DATE          
*/
    
public class BoardDTO {
	private int idx;
	private String title;
	private String writer;
	private String password;
	private String content;
	private int viewCount;
	private Date wdate;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
}
