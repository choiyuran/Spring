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

	int campingInsert(CampingDTO form);
	int maxCampingIdx();

	int campingImgInsert(CampingDTO form);

	int activityInsert(CampingDTO param);

	int introduceInsert(CampingDTO param);

	int internalInsert(HashMap<String, Object> map);

	int safetyDeviceInsert(HashMap<String, Object> map);

	int campingSiteInsert(HashMap<String, Object> map);


	

	



}
