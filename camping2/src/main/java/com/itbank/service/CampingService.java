package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CampingDTO;
import com.itbank.repository.CampingDAO;

@Service
public class CampingService {

	@Autowired private CampingDAO campingDAO;

	public CampingDTO selectOne(int camping_idx) {
		return campingDAO.selectOne(camping_idx);
	}

	public List<CampingDTO> selectOneImage(int camping_idx) {
		return campingDAO.selectOneImage(camping_idx);
	}

	public int getTotalCount() {
		return campingDAO.getTotalCount();
	}

	public List<CampingDTO> selectAll(HashMap<String, Object> param) {
		return campingDAO.selectAll(param);
	}

	public List<CampingDTO> search(Map<String, Object> param) {
		return campingDAO.search(param);
	}

	public int getSearchTotal(HashMap<String, Object> param) {
		return campingDAO.getSearchTotal(param);
	}







	


	

	

	
	




	
	
}
