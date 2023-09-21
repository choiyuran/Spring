package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	@Autowired private FileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	
	public int write(BoardDTO dto) {
		int idx = 0;
//		if(dto.getUpload().getSize() != 0 ) {			// 파일 내용은 없을지언정 파일 형태는 있기 때문에 null조건으로 체크하면 안먹힘
		if(dto.getUpload().isEmpty() == false) {		// 파일이 비어있는게 거짓이면(즉, 파일이 비어있지 않으면)
			// 파일 전송하고 파일 이름을 dto에 setting하여 insertBoard 실행
			String fileName = fileComponent.upload(dto.getUpload());		// multipart파일을 전달해서 파일 이름을 가져와서
			dto.setFileName(fileName);	// dto에 세팅해주고
		}
		
		// 정상적으로 추가되면 selectMaxIdx 실행해서 가장 최근 idx를 불러와서 반환
		int row = boardDAO.insertBoard(dto);
		if(row != 0) {
			idx = boardDAO.selectMaxIdx();
		}
		return idx;
	}

	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}

	public BoardDTO selectOne(int idx) {
		BoardDTO dto = boardDAO.selectOne(idx);
		return dto;
	}

	public int deleteBoard(int idx) {
		// 만약 idx번 게시글의 첨부파일이 있으면 삭제하고
		String fileName = boardDAO.selectFileName(idx);
		if(fileName != null) {
			fileComponent.deleteFile(fileName);
		}
		// idx번 게시글을 delete처리한다
		return boardDAO.deleteBoard(idx);
	}

}
