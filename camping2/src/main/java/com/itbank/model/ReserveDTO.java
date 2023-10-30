package com.itbank.model;

import java.sql.Date;

public class ReserveDTO {
	private int reserve_idx;
	private int user_idx;
	private int camping_idx;
	private String reserve_site;
	private int reserve_price;
	private Date reserve_str_date;
	private int human_cnt;
	private int car_ctn;
	private Date reserve_end_date;
	public int getReserve_idx() {
		return reserve_idx;
	}
	public void setReserve_idx(int reserve_idx) {
		this.reserve_idx = reserve_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getCamping_idx() {
		return camping_idx;
	}
	public void setCamping_idx(int camping_idx) {
		this.camping_idx = camping_idx;
	}
	public String getReserve_site() {
		return reserve_site;
	}
	public void setReserve_site(String reserve_site) {
		this.reserve_site = reserve_site;
	}
	public int getReserve_price() {
		return reserve_price;
	}
	public void setReserve_price(int reserve_price) {
		this.reserve_price = reserve_price;
	}
	public Date getReserve_str_date() {
		return reserve_str_date;
	}
	public void setReserve_str_date(Date reserve_str_date) {
		this.reserve_str_date = reserve_str_date;
	}
	public int getHuman_cnt() {
		return human_cnt;
	}
	public void setHuman_cnt(int human_cnt) {
		this.human_cnt = human_cnt;
	}
	public int getCar_ctn() {
		return car_ctn;
	}
	public void setCar_ctn(int car_ctn) {
		this.car_ctn = car_ctn;
	}
	public Date getReserve_end_date() {
		return reserve_end_date;
	}
	public void setReserve_end_date(Date reserve_end_date) {
		this.reserve_end_date = reserve_end_date;
	}
	
	
}
