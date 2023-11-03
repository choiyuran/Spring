package com.itbank.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itbank.model.CampingDTO;

public interface CampingDAO {

	CampingDTO selectOne(int camping_idx);

	List<CampingDTO> selectOneImage(int camping_idx);
	
	int getTotalCount();

	List<CampingDTO> selectAll(HashMap<String, Object> param);

	List<CampingDTO> search(Map<String, Object> param);

	int getSearchTotal(HashMap<String, Object> param);

	int campingInsert(CampingDTO dto);
	int maxCampingIdx();

	int campingImgInsert(CampingDTO dto);

	int campingPlaceInsert(CampingDTO dto);

	int activityInsert(CampingDTO param);

	int introduceInsert(CampingDTO param);

	int internalInsert(CampingDTO dto);

	int safetyDeviceInsert(CampingDTO dto);

	int campingSiteInsert(CampingDTO dto);

	int updateCamping(CampingDTO dto);

	int updateCampingImg(CampingDTO dto);

	int updateInfoTwo(CampingDTO dto);

	int updateActivity(CampingDTO dto);

	int updateIntroduce(CampingDTO dto);

	int deleteCamping(int maxCampingIdx);

	int deleteCampingImg(CampingDTO dto);

	int deleteCampingActivity(int maxCampingIdx);

	int deleteCampingIntoduce(int maxCampingIdx);

	int deleteCampingPlace(int maxCampingIdx);

	CampingDTO selectCamping(int camping_idx);

	CampingDTO selectCampingTwo(int camping_idx);

	int updateInternal(CampingDTO dto);

	int updateSafety(CampingDTO dto);

	int updateSite(CampingDTO dto);

	CampingDTO selectCampingThree(int camping_idx);

	CampingDTO selectOneByImg(int maxCampingIdx);

	void deleteCampingInternal(int camping_idx);

	void deleteCampingSafetyDevice(int camping_idx);

	void deleteCampingSite(int camping_idx);

	CampingDTO selectInnerImg(int camping_idx);





	

	



}
