package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	@Select("select * from board_pass order by idx")
	List<BoardDTO> selectAll();

	@Update("update board_pass set viewCount=viewCount+1 where idx=#{idx}")
	int viewCount(int idx);
	
	@Select("select * from board_pass where idx=#{idx}")
	BoardDTO selectOne(int idx);

	@Insert("insert into board_pass(title, writer, password, content) "
			+ "values(#{title}, #{writer}, #{password}, #{content})")
	int insert(BoardDTO dto);

	@Update("update board_pass set title=#{title}, content=#{content} "
			+ "where idx=#{idx} and password=#{password}")
	int update(BoardDTO dto);

	@Delete("delete from board_pass where idx=#{idx} and password=#{password}")
	int delete(BoardDTO dto);

	@Select("select * from board_pass where title like '%${keyword}%'")
	List<BoardDTO> searchTitle(String keyword);

	@Select("select * from board_pass where writer like '%${keyword}%'")
	List<BoardDTO> searchWriter(String keyword);

	@Select("select * from board_pass where content like '%${keyword}%'")
	List<BoardDTO> searchContent(String keyword);

	

}
