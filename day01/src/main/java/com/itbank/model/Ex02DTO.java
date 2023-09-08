package com.itbank.model;
/*
	 private 필드와
	 public getter/setter로 구성된
	 자바 빈즈 형식의(기본 생성자는 기본적으로 있으니 보통은 꼭 적을 필요x) 
	 Ex02DTO를 생성합니다
	 
	 jsp에서는 String/primitive 타입은 jsp:useBean과 jsp:setProperty로 처리가 가능했지만
	 File/MultipartFile/Date 타입은 받아올수 없었다 (그래서 fileUtil.getDTO를 사용)
	 하지만 spring에서는 어지간하면 다 받아준다
 */
public class Ex02DTO {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
