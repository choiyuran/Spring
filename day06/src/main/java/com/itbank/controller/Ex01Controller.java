package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.FileComponent;
import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Controller
public class Ex01Controller {
	@Autowired
	private FileComponent fileComponent;
	@Autowired
	private UploadDAO uploadDAO;

	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(UploadDTO dto) {
		// 1) 제출 받은 파일을 지정된 위치에 복사한다
		// 2) DB에 저장할 이름을 반환받는다
		String storedFileName = fileComponent.upload(dto.getUpload());
		// 3) dto에는 원본 이름과 저장될 이름을 같이 넣어둔다
		dto.setOriginalFileName(dto.getUpload().getOriginalFilename());
		dto.setStoredFileName(storedFileName);
		System.out.println("원본 이름 : " + dto.getOriginalFileName());
		System.out.println("저장 이름 : " + dto.getStoredFileName());
		System.out.println();
		
		// 4) dao로 전달하여 db에 추가하고, 리다이렉트로 이동시킨다
		int row = uploadDAO.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		
		return "redirect:/ex02";
	}
}
