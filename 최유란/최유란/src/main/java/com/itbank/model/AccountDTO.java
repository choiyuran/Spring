package com.itbank.model;
/*
	create table account(
		    idx                 number          default account_seq.nextval primary key,
		    userid              varchar2(100)   not null unique,
		    userpw              varchar2(300)   not null,
		    username            varchar2(100)   not null,
		    salt                varchar2(100)   not null
		);
*/
public class AccountDTO {
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private String salt;
	
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
	
	
}
