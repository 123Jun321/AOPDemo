package AopTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.security.auth.login.AccountNotFoundException;

import Aop.domain.Account;
import Aop.service.AccountService;
import Aop.util.BeanFactory;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Account a = new Account(1, "�ؾ�", 1000);
		Account bAccount = new Account(2, "����ά", 2000);
		AccountService accountService = BeanFactory.GetAccountServiceImpl();
		accountService.Transfer(a, bAccount, 200);
		System.exit(0);
	}

}
