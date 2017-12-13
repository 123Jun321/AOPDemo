package Aop.service;

import Aop.domain.Account;

public interface AccountService {
	void Transfer(Account fromAccount,Account toAccount,double money);
}
