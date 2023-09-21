package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	
	public int join(MemberDTO dto) {
		// 새로운 솔트와 해시처리를 진행한 후 dao로 넘겨준다
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		return memberDAO.insertMember(dto);
	}


	public MemberDTO login(MemberDTO dto) {
		// userid를 조건으로 login을 받아온다
		MemberDTO login = memberDAO.selectOneById(dto.getUserid());
		// 일치하는 정보가 있다면(login이 null이 아니라면)
		if(login != null) {
			// 입력받은 비밀번호를 hash처리 해준 뒤
			String hash = hashComponent.getHash(dto.getUserpw(), login.getSalt());
			// hash처리한 비밀번호와 원래의 비밀번호가 일치하지 않으면 null을 반환
			if(hash.equals(login.getUserpw()) == false) {
				return null;
			}
		}
		// 일치한다면 login 계정을 반환
		return login;
	}
	
//	public MemberDTO login(MemberDTO dto) {
//		MemberDTO login = memberDAO.selectOneById(dto.getUserid());
//		if(login != null) {
//			String dbpw = login.getUserpw();
//			String userpw = hashComponent.getHash(dto.getUserpw(), login.getSalt());
//			if(dbpw.equals(userpw)) {		// DB에 저장된 해시와, 사용자 입력값 기반의 해시가 일치하면
//				return login;
//			}
//		}
//		return null;
//	}
	
}
