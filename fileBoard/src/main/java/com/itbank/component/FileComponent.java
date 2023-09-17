package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {

	private String saveDirectory = "C:\\upload";
	
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {
		String storedFileName = null;
		String originalFileName = f.getOriginalFilename();
		if(originalFileName == "") {
			originalFileName = "default.jpg";
		}
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		
		File dest = new File(saveDirectory, storedFileName);
		try {
			f.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return storedFileName;
	}

	public void remove(String FileName) {
		File dest = new File(saveDirectory, FileName);
		System.out.println(dest.delete());
	}
}
