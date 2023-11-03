package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
//    @Value("${cpath}")
//    private String cpath;
//    
//	private String saveDirectory = "C://workspace-camping/camping2/src/main/webapp/resources/first_img";
//	private String saveDirectory2 = cpath + "/webapp/resources/inner_img";
	private String saveDirectory = "C:\\first_img";
	private String saveDirectory2 = "C:\\inner_img";

	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File dir2 = new File(saveDirectory2);
		if(dir2.exists() == false) {
			dir2.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {
		String fileName = UUID.randomUUID().toString().replace("-", "").substring(6);;
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		fileName += ext;			// 확장자 붙이고
		File dest = new File(saveDirectory, fileName);
		try {
			f.transferTo(dest);
			return fileName;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String upload2(MultipartFile f) {
		String fileName = UUID.randomUUID().toString().replace("-", "").substring(6);;
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		fileName += ext;			// 확장자 붙이고
		File dest = new File(saveDirectory2, fileName);
		try {
			f.transferTo(dest);
			return fileName;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteFile(String fileName) {
		File dest = new File(saveDirectory, fileName);
		if(dest.exists()) {
			dest.delete();			
		}
	}
	public void deleteFile2(String fileName) {
		File dest = new File(saveDirectory2, fileName);
		if(dest.exists()) {
			dest.delete();			
		}
	}

}
