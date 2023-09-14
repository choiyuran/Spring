package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
	private String saveDirectory = "C:\\upload";
	
	// 서버가 시작할때 한번만 체크(생성자에 넣어놓으면)
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {		// f는 사용자가 올린 파일
		String fileName = null;
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));	// 원본파일에서 확장자를 따오는 것(마지막 .부터 끝까지 잘라내서 ext에 넣어줌)
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		
		File dest = new File(saveDirectory, storedFileName);		
		try {
			f.transferTo(dest);								// upload 함수를 다른 곳에서 사용할때 예외 처리 상관안하고 사용하게 하기 위해서 예외전가(throws)말고
			fileName = dest.getName();			// == f.getOriginalFilename(); ->originalFileName을 사용할때만 해당   // dest는 서버에 올린 파일 
		} catch (IllegalStateException | IOException e) {	// try~catch구문으로 안에서 미리 예외를 처리해준다
			e.printStackTrace();
		}		
		return fileName;
	}
	

}
