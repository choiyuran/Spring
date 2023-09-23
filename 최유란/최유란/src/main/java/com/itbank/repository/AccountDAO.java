package com.itbank.repository;

import com.itbank.model.AccountDTO;

public interface AccountDAO {

	AccountDTO selectOneByUserid(String userid);

	int accountJoin(AccountDTO dto);

}
