package com.itbank.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.FileComponent;
import com.itbank.model.CampingDTO;
import com.itbank.repository.CampingDAO;

@Service
public class CampingService {

	@Autowired private CampingDAO campingDAO;
	@Autowired private FileComponent fileComponent;

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

	public int campingInsert(CampingDTO form) {
		return campingDAO.campingInsert(form);
	}

	public int maxCampingIdx() {
		return campingDAO.maxCampingIdx();
	}

	public int campingImgInsert(CampingDTO form) {
		if(form.getUpload1().getSize() != 0) {
			String fileName = fileComponent.upload(form.getUpload1());
			form.setFirst_img(fileName);
		}
		MultipartFile[] files = form.getUpload2();
		if(files != null) {
			for(int i = 0; i < files.length; i++) {
				String fileName = fileComponent.upload(files[i]);
				 if (i < files.length - 1) {
			            fileName += ",";
			        }
				form.setInner_img(fileName);
			}
		}
		return campingDAO.campingImgInsert(form);
	}

	public int activityInsert(CampingDTO param) {
		if(param.getExprnprogrm() != null) {
			param.setExprnprogrmat("Y");
		}
		else {
			param.setExprnprogrmat("N");
		}
		return campingDAO.activityInsert(param);
	}

	public int introduceInsert(CampingDTO param) {
		return campingDAO.introduceInsert(param);
	}

	public int internalInsert(HashMap<String, Object> map) {
		return campingDAO.internalInsert(map);
	}

	public int safetyDeviceInsert(HashMap<String, Object> map) {
		return campingDAO.safetyDeviceInsert(map);
	}

	public int campingSiteInsert(HashMap<String, Object> map) {
		return campingDAO.campingSiteInsert(map);
	}







	


	

	

	
	




	
	
}
