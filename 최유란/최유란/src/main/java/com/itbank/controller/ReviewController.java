package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.AccountDTO;
import com.itbank.model.ReviewDTO;
import com.itbank.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired private ReviewService reviewService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<ReviewDTO> list = reviewService.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(ReviewDTO dto, HttpSession session) {
		AccountDTO login = (AccountDTO)session.getAttribute("login");
		dto.setAccount_idx(login.getIdx());
	
		int idx = reviewService.reviewWrite(dto);
		System.out.println(idx + "번째 리뷰가 등록되었습니다");			
		return "redirect:/review/view/" + idx;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("review/view");
		ReviewDTO dto = reviewService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		int row = reviewService.reviewDelete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/review/list";
	}
}
