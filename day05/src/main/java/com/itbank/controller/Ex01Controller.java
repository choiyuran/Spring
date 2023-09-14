package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.itbank.model.Ex02DTO;

@Controller
public class Ex01Controller {

	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(MultipartRequest request) throws IllegalStateException, IOException {
		String saveDirectory = "C:\\upload";
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		MultipartFile f = request.getFile("upload");					// 사용자가 제출한 파일
		File dest = new File(saveDirectory, f.getOriginalFilename());	// 서버에서 만든 파일 객체(비어있음)
		f.transferTo(dest);					// 사용자가 올린 파일을 지정한 위치로 전송한다
		
		System.out.println("input의 이름 : " + f.getName());
		System.out.println("원본 파일 이름 : " + f.getOriginalFilename());
		System.out.println("파일의 컨텐트 타입(형식) : " + f.getContentType());
		System.out.println("파일 크기 : " + f.getSize());
		System.out.println();
		return "redirect:/ex01";
	}
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Ex02DTO dto) throws IllegalStateException, IOException {
		File dir = new File("C:\\upload");			// 파일을 생성할 서버쪽 디렉토리를 지정한다
		if(dir.exists() == false) {					// 만약 업로드 디렉토리가 없으면
			dir.mkdirs();							// 생성한다
		}
		File dest = new File(dir, dto.getUpload().getOriginalFilename());
		// 업로드 디렉토리 내부에, 원본 파일이름으로 새로운 파일 객체를 생성한다
		// 이때 실제 파일이 생성되는 것은 아니다. (파일을 생성하기 위한 기본 위치정보만 저장되어있다)
		
		dto.getUpload().transferTo(dest);			// 사용자가 제출한 파일을 지정한 dest로 전송한다(파일이 생성됨)
		System.out.println("title : " + dto.getTitle());		// 사용자가 제출한 문자열 파라미터
		System.out.println("upload : " + dto.getUpload().getOriginalFilename());		// 파일
		System.out.println();
		return "redirect:/ex02";
	}
}
