package com.itbank.repository;

import java.util.List;

import com.itbank.model.ReviewDTO;

public interface ReviewDAO {

	List<ReviewDTO> selectAll();

	int reviewWrite(ReviewDTO dto);

	int getMaxIdx();

	ReviewDTO selectOne(int idx);

	int reviewDelete(int idx);

}
