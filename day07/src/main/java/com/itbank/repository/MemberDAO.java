package com.itbank.repository;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Insert("insert into member2 (userid, userpw, username, email, salt) "
			+ "values(#{userid}, #{userpw}, #{username}, #{email}, #{salt})")
	int insert(MemberDTO dto);

	@Select("select * from member2 where userid=#{userid}")
	MemberDTO selectOneByUserid(String userid);

	@Update("update member2 set salt=#{salt}, userpw=#{userpw} where userid=#{userid} and email=#{email}")
	int update(MemberDTO dto);

	@Update("update member2 set userpw=#{newHash}, salt=#{newSalt} where userid=#{userid} and userpw=#{oldHash}")
	int updatePw(HashMap<String, String> map);

	

	


}
