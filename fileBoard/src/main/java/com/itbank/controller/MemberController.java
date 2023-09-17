package com.itbank.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.FileComponent;
import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired private MemberDAO memberDAO;
	@Autowired private FileComponent fileComponent;
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public ModelAndView join(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/member/list");
		
		String originalFileName = dto.getUpload().getOriginalFilename();
		String storedFileName = fileComponent.upload(dto.getUpload());
		if(originalFileName == "") {
			originalFileName = "default.jpg";
		}
		System.out.println(originalFileName);

		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		
		dto.setOriginalFileName(originalFileName);
		dto.setStoredFileName(storedFileName);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		int row = memberDAO.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return mav;
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpSession session) {
		MemberDTO login = memberDAO.selectOne(dto);
		if(login == null) {
			return "redirect:/member/login";
		}
		String hash = hashComponent.getHash(dto.getUserpw(), login.getSalt());
		if(hash.equals(login.getUserpw()) == false) {
			return "redirect:/member/login";
		}
		session.setAttribute("login", login);
		return "redirect:/member/list"; 
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("login") != null) {
			session.invalidate();
		}
		return "redirect:/member/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("member/view");
		MemberDTO dto = memberDAO.selectView(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView("member/update");
		MemberDTO dto = memberDAO.selectView(idx);
		if(session.getAttribute("login") == null) {
			mav.setViewName("member/msg");
		}
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(@RequestParam Map<String, String> map, HttpSession session, MemberDTO file) {
		ModelAndView mav = new ModelAndView("redirect:/member/list");
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String currentPw = map.get("currentPw");
		String newPw = map.get("newPw");
		
		String salt = hashComponent.getRandomSalt();
		String newHash = hashComponent.getHash(newPw, salt);
		String currentHash = hashComponent.getHash(currentPw, dto.getSalt());
		if(currentHash.equals(dto.getUserpw())) {
			map.put("salt", salt);
			map.put("newHash", newHash);
			map.put("currentHash", currentHash);
			map.put("userid", dto.getUserid());
			
			String originalFileName = file.getUpload().getOriginalFilename();
			String storedFileName = fileComponent.upload(file.getUpload());
		
			if(originalFileName == "") {
				originalFileName = "default.jpg";
				storedFileName = "";
			}
			map.put("originalFileName", originalFileName);
			map.put("storedFileName", storedFileName);
			int row = memberDAO.update(map);

			if(row != 0) {
				System.out.println(row + "행이 업데이트 되었습니다");
				session.invalidate();
				mav.setViewName("redirect:/member/login");
			}
		}		
		
		return mav;
	}
	
	@GetMapping("/removeFile/{storedFileName}/{idx}") 
	public String removeFile(@PathVariable("storedFileName")String FileName, @PathVariable("idx") int idx, MemberDTO dto) {
		System.out.println(FileName);
		dto.setIdx(idx);
		memberDAO.removeFile(dto);
		fileComponent.remove(FileName);		
		return "redirect:/member/update/{idx}";
	}
	
	@GetMapping("/delete/{idx}/{storedFileName}")
	public String delete(@PathVariable("idx") int idx, @PathVariable("storedFileName")String FileName, HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "member/msg";
		}
		else {
			fileComponent.remove(FileName);
			System.out.println(FileName);
			int row = memberDAO.delete(idx);
			System.out.println(row + "행이 삭제되었습니다");
			return "redirect:/member/list";			
			
		}
		
		
		
	}
}
