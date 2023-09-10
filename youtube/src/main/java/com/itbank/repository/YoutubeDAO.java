package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.YoutubeDTO;

public interface YoutubeDAO {

	@Select("select * from youtube order by idx")
	List<YoutubeDTO> selectAll();

	@Select("select * from youtube where idx=#{idx}")
	YoutubeDTO selectOne(int idx);

	@Delete("delete from youtube where idx=#{idx}")
	int delete(int idx);

	@Update("update youtube set title=#{title}, channel=#{channel}, thumbnail=#{thumbnail} where idx =#{idx}")
	int update(YoutubeDTO dto);

	@Insert("insert into youtube(idx, title, channel, thumbnail, movieTag) "
			+ "values(${idx}, #{title}, #{channel}, #{thumbnail}, #{movieTag})")
	int insert(YoutubeDTO dto);

	@Update("update youtube set viewCount = viewCount+1 where idx=${idx}")
	int viewCount(int idx);

}
