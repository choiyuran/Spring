package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public int campingInsert(CampingDTO dto) {
		if(dto.getInduty() == null)  {
			dto.setInduty("일반야영장");
		}
		return campingDAO.campingInsert(dto);
	}

	public int maxCampingIdx() {
		return campingDAO.maxCampingIdx();
	}

	public int campingImgInsert(CampingDTO dto) {
		if(dto.getUpload1().getSize() != 0) {
			String fileName = fileComponent.upload(dto.getUpload1());
			dto.setFirst_img(fileName);
		}
		if(dto.getUpload2() != null) {
			String innerFileName = "";
			for(int i = 0; i < dto.getUpload2().length; i++) {
				String fileName = fileComponent.upload2(dto.getUpload2()[i]);
				innerFileName += fileName;
				 if (i < dto.getUpload2().length - 1) {
					 innerFileName += ",";
			        }
			}
			dto.setInner_img(innerFileName);
		}
		return campingDAO.campingImgInsert(dto);
	}
	
	public int campingPlaceInsert(CampingDTO dto) {
		return campingDAO.campingPlaceInsert(dto);
	}

	public int activityInsert(CampingDTO dto) {
		if(dto.getExprnprogrm() != null) {
			dto.setExprnprogrmat("Y");
		}
		else {
			dto.setExprnprogrmat("N");
		}
		return campingDAO.activityInsert(dto);
	}

	public int introduceInsert(CampingDTO param) {
		return campingDAO.introduceInsert(param);
	}

	public int internalInsert(CampingDTO dto) {
		return campingDAO.internalInsert(dto);
	}

	public int safetyDeviceInsert(CampingDTO dto) {
		return campingDAO.safetyDeviceInsert(dto);
	}

	public int campingSiteInsert(CampingDTO dto) {
		return campingDAO.campingSiteInsert(dto);
	}

	public int updateCamping(CampingDTO dto) {
		return campingDAO.updateCamping(dto);
	}

	public int updateCampingImg(CampingDTO dto) {
		if(dto.getUpload1().getSize() != 0) {
			String fileName = fileComponent.upload(dto.getUpload1());
			dto.setFirst_img(fileName);
		}
		if(dto.getUpload2() != null) {
			String innerFileName = "";
			for(int i = 0; i < dto.getUpload2().length; i++) {
				String fileName = fileComponent.upload2(dto.getUpload2()[i]);
				innerFileName += fileName;
				 if (i < dto.getUpload2().length - 1) {
					 innerFileName += ",";
			        }
			}
			dto.setInner_img(innerFileName);
		}
		
		return campingDAO.updateCampingImg(dto);
	}
	
	public int updateInfoTwo(CampingDTO dto) {
		return campingDAO.updateInfoTwo(dto);
	}

	public int updateActivity(CampingDTO dto) {
		if(dto.getExprnprogrm() != null) {
			dto.setExprnprogrmat("Y");
		}
		else {
			dto.setExprnprogrmat("N");
		}
		return campingDAO.updateActivity(dto);
	}

	public int updateIntroduce(CampingDTO dto) {
		return campingDAO.updateIntroduce(dto);
	}

	// 이전
	public int deleteCamping(int maxCampingIdx) {
		return campingDAO.deleteCamping(maxCampingIdx);
	}

	public int deleteCampingImg(CampingDTO dto) {
		fileComponent.deleteFile(dto.getFirst_img());
		String[] fileName = dto.getInner_img().split(",");
		for(int i = 0; i < fileName.length; i++) {
			fileComponent.deleteFile2(fileName[i]);
		}
		return campingDAO.deleteCampingImg(dto);
	}

	public int deleteCampingActivity(int maxCampingIdx) {
		return campingDAO.deleteCampingActivity(maxCampingIdx);
	}

	public int deleteCampingIntoduce(int maxCampingIdx) {
		return campingDAO.deleteCampingIntoduce(maxCampingIdx);
	}
	
	public int deleteCampingPlace(int maxCampingIdx) {
		return campingDAO.deleteCampingPlace(maxCampingIdx);
	}
	public void deleteCampingInternal(int camping_idx) {
		campingDAO.deleteCampingInternal(camping_idx);
	}

	public void deleteCampingSafetyDevice(int camping_idx) {
		campingDAO.deleteCampingSafetyDevice(camping_idx);
	}
	
	public void deleteCampingSite(int camping_idx) {
		campingDAO.deleteCampingSite(camping_idx);
	}
	
	public CampingDTO selectCamping(int camping_idx) {
		return campingDAO.selectCamping(camping_idx);
	}

	public CampingDTO selectCampingTwo(int camping_idx) {
		return campingDAO.selectCampingTwo(camping_idx);
	}

	public int updateInternal(CampingDTO dto) {
		return campingDAO.updateInternal(dto);
	}

	public int updateSafety(CampingDTO dto) {
		return campingDAO.updateSafety(dto);
	}

	public int updateSite(CampingDTO dto) {
		return campingDAO.updateSite(dto);
	}

	public CampingDTO selectCampingThree(int camping_idx) {
		return campingDAO.selectCampingThree(camping_idx);
	}

	public CampingDTO selectOneByImg(int maxCampingIdx) {
		return campingDAO.selectOneByImg(maxCampingIdx);
	}

	public CampingDTO selectInnerImg(int camping_idx) {
		return campingDAO.selectInnerImg(camping_idx);
	}

	

	



	










	


	

	

	
	




	
	
}
