package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	@Autowired private MemberDAO memberDAO;
	
	public int join(MemberDTO dto) {
		int row = memberDAO.join(dto);
		return row;
	}
	

}
