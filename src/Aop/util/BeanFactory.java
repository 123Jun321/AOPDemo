package Aop.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import Aop.domain.Account;
import Aop.service.AccountService;
import Aop.serviceImpl.AccountServiceImpl;

public class BeanFactory {
	public static AccountService GetAccountServiceImpl() {
		final AccountService accountService = new AccountServiceImpl();
		AccountService s = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
				accountService.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
						try {
							TransactionFactory.statTranction();
							Object result = arg1.invoke(accountService, arg2);
							return result;
						} catch (Exception e) {
							// TODO: handle exception
							TransactionFactory.RollBack();
							throw new RuntimeException(e);
						} finally {
							TransactionFactory.Commit();
							TransactionFactory.release();
						}
						// TODO Auto-generated method stub

					}
				});
		return s;
	}

}
