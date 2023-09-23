package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.ReviewDTO;
import com.itbank.repository.ReviewDAO;

@Service
public class ReviewService {
	@Autowired private ReviewDAO reviewDAO;
	@Autowired private FileComponent fileComponent;
	
	public List<ReviewDTO> selectAll() {
		return reviewDAO.selectAll();
	}

	public int reviewWrite(ReviewDTO dto) {
		String fileName = fileComponent.upload(dto.getUpload());
		dto.setFileName(fileName);
		
		int idx = 0;
		int row = reviewDAO.reviewWrite(dto);
		if(row != 0) {
			idx = reviewDAO.getMaxIdx();
		}
		return idx;
	}

	public ReviewDTO selectOne(int idx) {
		return reviewDAO.selectOne(idx);		
	}

	public int reviewDelete(int idx) {
		ReviewDTO dto = reviewDAO.selectOne(idx);
		String fileName = dto.getFileName();
		fileComponent.removeFile(fileName);
		return reviewDAO.reviewDelete(idx);
	}
}
