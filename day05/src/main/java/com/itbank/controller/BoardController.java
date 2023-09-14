package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDAO boardDAO;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/board/list");
		List<BoardDTO> list = boardDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	@PostMapping("/write")
	public String writer(BoardDTO dto) {
		int row = boardDAO.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/board/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView  view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		BoardDTO dto = boardDAO.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete() {
		return "/board/delete";
	}
	
	@PostMapping("/delete/{idx}")			// PathVariable도 커멘드 객체에 이름이 맞는 필드가 있으면
	public String delete(BoardDTO dto) {	// dto에 자동으로 값이 입력된다
		System.out.println("idx : " + dto.getIdx());
		System.out.println("pw : " + dto.getPassword());
		
		int row = boardDAO.delete(dto);
		System.out.println(row + "행이 삭제되었습니다");
		
		if(row == 0) {
			return "redirect:/board/view/{idx}";
			// PathVariable로 들어온 주소값은 viewName반환시에도 사용가능하다
		}
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify/{idx}")
	public String modify() {
		return "/board/modify";
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(BoardDTO param) {
		ModelAndView mav = new ModelAndView();
		BoardDTO dto = boardDAO.selectOneByIdxAndPw(param);
		if(dto == null) {		// 비밀번호가 일치하지 않으면 dto를 받지 못한다
			mav.setViewName("redirect:/board/view/{idx}");
		}
		else {
			mav.addObject("dto", dto);
			mav.setViewName("/board/modify");
		}
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(BoardDTO dto) {
		int row = boardDAO.update(dto);
		System.out.println(row + "행이 수정되었습니다");
		return "redirect:/board/view/{idx}";
	}
}
