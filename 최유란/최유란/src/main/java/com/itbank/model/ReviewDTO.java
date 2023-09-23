package com.itbank.model;
/*
	create table review(
		    idx             number          default review_seq.nextval primary key,
		    title           varchar2(100)   not null,
		    account_idx     number          not null,
		    content         varchar2(4000)  not null,
		    wdate           date            default sysdate,
		    filename        varchar2(255)   not null,
		    
		    constraint review_account_fk
		    foreign key (account_idx)
		    references account(idx)
		);
*/

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReviewDTO {
	private int idx;
	private String title;
	private int account_idx;
	private String content;
	private Date wdate;
	private String fileName;
	
	private MultipartFile upload;
	private String account_userid;
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
	public int getAccount_idx() {
		return account_idx;
	}
	public void setAccount_idx(int account_idx) {
		this.account_idx = account_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getAccount_userid() {
		return account_userid;
	}
	public void setAccount_userid(String account_userid) {
		this.account_userid = account_userid;
	}
	
	
}
