package com.itbank.model;

import java.sql.Date;

public class FreeDTO {

	// free_reply
	private int user_idx;
	private int free_table_idx;
	private Date reply_wdate;
	private String reply_content;
	
	// free_table
	private String free_title;
	private String free_content;
	private String free_img;
	private Date free_wdate;
	private int free_viewCount;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getFree_table_idx() {
		return free_table_idx;
	}
	public void setFree_table_idx(int free_table_idx) {
		this.free_table_idx = free_table_idx;
	}
	public Date getReply_wdate() {
		return reply_wdate;
	}
	public void setReply_wdate(Date reply_wdate) {
		this.reply_wdate = reply_wdate;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_content() {
		return free_content;
	}
	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}
	public String getFree_img() {
		return free_img;
	}
	public void setFree_img(String free_img) {
		this.free_img = free_img;
	}
	public Date getFree_wdate() {
		return free_wdate;
	}
	public void setFree_wdate(Date free_wdate) {
		this.free_wdate = free_wdate;
	}
	public int getFree_viewCount() {
		return free_viewCount;
	}
	public void setFree_viewCount(int free_viewCount) {
		this.free_viewCount = free_viewCount;
	}
	
	
}
