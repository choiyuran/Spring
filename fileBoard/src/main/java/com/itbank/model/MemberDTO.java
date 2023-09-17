package com.itbank.model;


import org.springframework.web.multipart.MultipartFile;

/*
	create table member3(
	    idx                     number             default member3_seq.nextval primary key,
	    userid                  varchar2(50)       not null unique,
	    userpw                  varchar2(50)       not null,
	    username                varchar2(50)       not null,
	    salt                    varchar2(50)       not null,
	    email                   varchar2(100)      not null unique,
	    originalFileName        varchar2(500),      
	    storedFileName          varchar2(500)
	);
*/

public class MemberDTO {
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private String salt;
	private String email;
	private String originalFileName;
	private String storedFileName;
	private MultipartFile upload;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	
	
	
	

	
	
}
