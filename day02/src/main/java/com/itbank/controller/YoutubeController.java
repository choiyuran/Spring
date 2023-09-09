package com.itbank.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.repository.YoutubeDAO;

@Controller
public class YoutubeController {
	
	// 컨트롤러의 함수 반환형을 결정하기
	// 1) DB에서 불러온 데이터 혹은 다른 데이터를 JSP에게 넘겨줘야 하는가?
	// yes -> ModelAndView
	
	// 2) 요청 주소와 JSP의 이름이 일치하는가?
	// yes -> void, no -> String
	
	@Autowired
	private YoutubeDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<YoutubeDTO> list = dao.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		/**** dto.movieTag의 문자열을 수정하는 코드 (service로 이동가능) ***/
		String movieTag = dto.getMovieTag();
		String[] tag = movieTag.split(" ");
		for(int i = 0; i < tag.length; i++) {
			if(tag[i].startsWith("width")) { 
				tag[i] = "width=\"720\"";
			}
			if(tag[i].startsWith("height")) {
				tag[i] = "height=\"405\"";
			}
		}
		String newTag = String.join(" ", tag);
		dto.setMovieTag(newTag); 
		/********************************************************/
		
		int row =  dao.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}") 
	// 위 주소에서 PathVariable로 등록된 것과 같은 부분을 찾아서 정수형으로 변환 후 int idx에 담아준다
	public ModelAndView view(@PathVariable("idx") int idx) {		
		ModelAndView mav = new ModelAndView("view");
		dao.viewCount(idx);
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")		// <a href="">, location.href 모두 GET 메서드이다
	public String delete(@PathVariable("idx") int idx) {
		int row = dao.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/list";
	}
	

	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("update");
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update")
	public String update(YoutubeDTO dto) {
		int row = dao.update(dto);
		System.out.println(row + "행이 수정되었습니다");
		return "redirect:/list";
	}
	
}
