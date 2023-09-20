package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;


@Service
public class MemberService {

	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	public MemberDTO login(MemberDTO dto) {
		// 1) 해시 처리되지 않은 사용자 입력값(request에 담겨서 넘어온 데이터)을 받아서
		// 2) DB에 저장된 값과 비교할 수 있도록 해시처리하고 난 값을 DAO에게 넘겨준다
		MemberDTO login = memberDAO.selectOneByUserid(dto.getUserid());
		if(login != null) {		// userid가 있으면 실행
			// 사용자 입력값으로 만들어낸 해시
			String userpw = hashComponent.getHash(dto.getUserpw(), login.getSalt());
	
			// login.getUserpw() : DB에 저장된 해시
			if(userpw.equals(login.getUserpw()) == false) {		// 패스워드가 맞지 않을 경우
				login = null;
			}		
		}
		// 3) DAO에 의해 처리된 값(객체)을 컨트롤러에게 반환하여 이후 처리를 진행하도록 한다
		return login;
	}

	public int join(MemberDTO dto) {
		// 1) 랜덤 salt를 생성
		String salt = hashComponent.getRandomSalt();
		
		// 2) salt를 이용하여 hash를 생성
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		
		// 3) hash를 userpw에 대입
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		// 4) dao에게 전달하여 insert
		int row = memberDAO.insertMember(dto);
		return row;
	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = memberDAO.selectAll();
		list.forEach(member -> member.setUserpw("x"));	// DB에서 불러오긴 했는데, pw를 보여줄 필요가 없으므로 x로 대체해준다
		return list;
	}

	

}
