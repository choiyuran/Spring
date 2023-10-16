package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	@Select("select * from member6 where userid=#{userid}")
	public MemberDTO selectOneByUserid(String userid);

	@Insert("insert into member6 values(#{userid}, #{userpw}, #{username}, #{gender})")
	public int insert(MemberDTO dto);

	@Select("select * from member6 order by userid")
	public List<MemberDTO> selectList();

}
