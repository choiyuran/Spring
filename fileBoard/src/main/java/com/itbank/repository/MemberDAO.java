package com.itbank.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Select("select * from member3 order by idx desc")
	List<MemberDTO> selectAll();

	@Insert("insert into member3 (userid, userpw, username, salt, email, originalFileName, storedFileName) "
			+ "values(#{userid}, #{userpw}, #{username}, #{salt}, #{email}, #{originalFileName}, #{storedFileName})")
	int insert(MemberDTO dto);

	@Select("select * from member3 where userid=#{userid}")
	MemberDTO selectOne(MemberDTO dto);

	@Select("select * from member3 where idx=#{idx}")
	MemberDTO selectView(int idx);

	@Update("update member3 set "
			+ "userpw=#{newHash}, salt=#{salt}, originalFileName=#{originalFileName}, storedFileName=#{storedFileName} "
			+ "where userid=#{userid} and userpw=#{currentHash}")
	int update(Map<String, String> map);

	@Update("update member3 set "
			+ "originalFileName=null, storedFileName=null where idx=#{idx}")
	int removeFile(MemberDTO ob);

	@Delete("delete member3 where idx=#{idx}")
	int delete(int idx);

}
