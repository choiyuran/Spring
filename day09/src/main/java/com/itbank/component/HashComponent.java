package com.itbank.component;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
//import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {
	
	private Random random = new Random(); 
	private String sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public String getRandomSalt() {
		String salt = "";
		for(int i = 0; i < 12; i++) {
			salt += sample.charAt(random.nextInt(sample.length()));
		}
		return salt;
	}
	
	
//	public String getRandomSalt() {
//		String salt = UUID.randomUUID().toString().substring(0, 8);
//		return salt;
//	}

	public String getHash(String source, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");	// Secure Hash Algorithm
			md.update(salt.getBytes());
			md.update(source.getBytes());
			
			String hash = String.format("%0128X", new BigInteger(1, md.digest()));			// 양수로 처리하려면 1, 음수로 처리하려면 -1, 0으로 처리하려면 0/ md.digest를 사용해서 문자열을 섞어준다
			return hash;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}




}
