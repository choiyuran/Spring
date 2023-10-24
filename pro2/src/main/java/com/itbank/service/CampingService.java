package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CampingDTO;
import com.itbank.repository.CampingDAO;

@Service
public class CampingService {

	@Autowired private CampingDAO campingDAO;

	public List<CampingDTO> selectAll() {
		List<CampingDTO> list = campingDAO.selectAll();
		return list;
	}

	public CampingDTO selectOne(String facltnm) {
		return campingDAO.selectOne(facltnm);
	}




}
