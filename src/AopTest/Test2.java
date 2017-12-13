package AopTest;

import Aop.daoimpl.AccountDaoImpl;
import Aop.domain.Account;
import Aop.service.AccountService;
import Aop.util.BeanFactory;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account(1, "¹Ø¾ü", 20000);
		Account bAccount = new Account(2, "ÂÞÏþÎ¬", 2000);
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		accountDaoImpl.UpdateAccount(a);
		System.out.println("Ok");
	}

}
