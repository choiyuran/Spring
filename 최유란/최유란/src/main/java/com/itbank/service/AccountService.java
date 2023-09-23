package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.AccountDTO;
import com.itbank.repository.AccountDAO;

@Service
public class AccountService {
	@Autowired private HashComponent hashComponent;
	@Autowired private AccountDAO accountDAO;
	
	
	public AccountDTO login(AccountDTO dto) {
		AccountDTO login = accountDAO.selectOneByUserid(dto.getUserid());
		if(login != null) {
			String pw = login.getUserpw();
			String hash = hashComponent.getHash(dto.getUserpw(), login.getSalt());
			if(hash.equals(pw)) {
				return login;
			}
		}
		return null;
	}


	public int accountJoin(AccountDTO dto) {
		String salt = hashComponent.getSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		int row = accountDAO.accountJoin(dto);
		return row;
	}

}
