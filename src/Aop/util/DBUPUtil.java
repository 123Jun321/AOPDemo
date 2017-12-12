package Aop.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.*;

public class DBUPUtil {
	private static DataSource dataSource;

	static {
		InputStream inputStream = DBUPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		Properties props = new Properties();
		try {
			props.load(inputStream);
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
