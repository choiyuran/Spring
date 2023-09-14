package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.BoardDTO;

public interface BoardDAO {

	@Select("select * from board_pass order by idx desc")
	List<BoardDTO> selectAll();

	@Insert("insert into board_pass(title, writer, content, password) values(#{title}, #{writer}, #{content}, #{password})")
	int insert(BoardDTO dto);

	@Select("select * from board_pass where idx=#{idx}")
	BoardDTO selectOne(int idx);

	@Delete("delete board_pass where idx=#{idx} and password=#{password}")
	int delete(BoardDTO dto);

	@Select("select * from board_pass where idx=#{idx} and password=#{password}")
	BoardDTO selectOneByIdxAndPw(BoardDTO param);

	@Update("update board_pass set title=#{title}, writer=#{writer}, content=#{content} where idx=#{idx}")
	int update(BoardDTO dto);

}
