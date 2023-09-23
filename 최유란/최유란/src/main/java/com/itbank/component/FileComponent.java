package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
	private String saveDirectory = "C:\\upload";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {
		String fileName = sdf.format(new Date()) + "_" + f.getOriginalFilename();
		File dest = new File(saveDirectory, fileName);
		try {
			f.transferTo(dest);
			return fileName;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void removeFile(String fileName) {
		File dest = new File(saveDirectory, fileName);
		if(dest.exists()) {
			dest.delete();
		}
	}

}
