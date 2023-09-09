package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.YoutubeDTO;

public interface YoutubeDAO {

	@Select("select * from youtube order by idx")
	List<YoutubeDTO> selectList();

	// String sql = "insert into youtube values(?, ?, ?, ?, ?)";
	// #{} 이것과  ${} 이것의 차이
	// 검색을 하는 경우에는 컬럼명을 그대로 써야하는데 select * from where name '%' || 검색어 || '%' 이런식으로
	// #{} 이걸 사용하게 되면 select * from where 'name' '%' || 검색어 || '%' 이렇게 컬럼명에도 따옴표가 붙기 때문에 문자 그대로 따옴표 없이 사용하는 구문에는 ${}를 사용한다 
	@Insert("insert into youtube values(#{idx}, #{title}, #{channel}, #{viewCount}, #{thumbnail}, #{movieTag})")
	int insert(YoutubeDTO dto);

	// 애초에 sql 구문에서 ''가 안붙을 경우에는 ${}를 사용해도 괜찮다(정수에는 $를 사용해도 된다)
	@Select("select * from youtube where idx = #{idx}")
	YoutubeDTO selectOne(int idx);

	@Delete("delete from youtube where idx=#{idx}")
	int delete(int idx);

	@Update("update youtube set viewCount = viewCount+1 where idx=#{idx}")
	int viewCount(int idx);

	@Update("update youtube set title=#{title}, channel=#{channel}, thumbnail=#{thumbnail} where idx=#{idx}") 
	int update(YoutubeDTO dto);

}
