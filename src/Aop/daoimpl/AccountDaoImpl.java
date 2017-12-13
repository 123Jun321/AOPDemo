package Aop.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import Aop.dao.AccountDao;
import Aop.domain.Account;
import Aop.util.DBUPUtil;

public class AccountDaoImpl implements AccountDao {
	private QueryRunner query = new QueryRunner();

	@Override
	public void UpdateAccount(Account account) {
		// TODO Auto-generated method stub
		try {
			query.update(DBUPUtil.getConnection(), "update account set money=? where AccountID=?", account.getMoney(),
					account.getAccountID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
