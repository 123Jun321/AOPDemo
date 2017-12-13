package Aop.serviceImpl;

import Aop.dao.AccountDao;
import Aop.daoimpl.AccountDaoImpl;
import Aop.domain.Account;
import Aop.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao accountdao = new AccountDaoImpl();

	@Override
	public void Transfer(Account fromAccount, Account toAccount, double money) {
		// TODO Auto-generated method stub
		fromAccount.setMoney(fromAccount.getMoney() - money);
		toAccount.setMoney(toAccount.getMoney() + money);
		accountdao.UpdateAccount(fromAccount);
		accountdao.UpdateAccount(toAccount);
	}

}
