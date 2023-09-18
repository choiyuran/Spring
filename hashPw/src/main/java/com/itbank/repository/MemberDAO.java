package com.itbank.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Insert("insert into member2(userid, userpw, salt, username, email) "
			+ "values(#{userid}, #{userpw}, #{salt}, #{username}, #{email})")
	int insert(MemberDTO dto);

	@Select("select * from member2 where userid=#{userid}")
	MemberDTO selectOne(String userid);

	@Select("select * from member2 where userid=#{userid} and email=#{email}")
	MemberDTO selectOneByIdEmail(MemberDTO dto);

	@Update("update member2 set userpw=#{userpw}, salt=#{salt} where userid=#{userid} and email=#{email}")
	int updatePw(MemberDTO dto);

	@Update("update member2 set userpw=#{newHash}, salt=#{newSalt} "
			+ "where userid=#{userid} and userpw=#{hashCurrent}")
	int update(Map<String, String> map);

}
