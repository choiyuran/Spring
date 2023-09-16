package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {
	
	public String getRandomSalt() {
		String salt = null;
		SecureRandom ran = new SecureRandom();			// 보안에 활용할 수 있는 수준의 랜덤
		byte[] arr = new byte[16];
		ran.nextBytes(arr);
		salt = new String(Base64.getEncoder().encode(arr));
		return salt;
	}
	
	
	public String getHash(String source, String salt) {			// 원본 문자열
		String hash = null;							// 해시값을 담을 문자열
		MessageDigest md = null;					// 해시 알고리즘을 처리할 객체
		try {
			md = MessageDigest.getInstance("SHA-512");		// 해시 알고리즘 : SHA-512
			
			// 원본 소스를 추가하기 전, salt도 같이 추가한다
			// salt값을 모르면 원본 데이터의 값을 모른다 그래서 salt 값도 같이 필요함(해시로 나온 데이터를 한번 더 랜덤값으로 바꿔줌)
//			salt = getRandomSalt();
			md.update(salt.getBytes());
			md.update(source.getBytes());			// 원본 소스를 바이트 형태로 추가
			// 원본과 상관없이 128자리수로 나온다(알파벳이 대문자로 나오길 바라면 대문자X, 소문자 알파벳으로 나오길 원하면 소문자x)
			// 원본 소스를 SHA512형식을 적용한 해시로 숫자를 추출하고,		
			// 추출된 숫자를 128자리의 16진수 문자열로 만들기
			hash = String.format("%0128X", new BigInteger(1, md.digest()));	// 일반적인 정수나 long으로도 처리할 수 없기 때문에 BigInteger클래스를 사용한다	
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
}


