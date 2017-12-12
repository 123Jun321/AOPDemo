package Aop.util;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sound.midi.VoiceStatus;
import javax.xml.stream.events.StartDocument;

public class TransactionFactory {
	private static ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection connection = threadConnection.get();
		if (connection == null) {
			try {
				connection = DBUPUtil.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadConnection.set(connection);
		}
		return connection;
	}

	public static void statTranction() {
		Connection connection = getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void RollBack() {
		Connection connection = getConnection();
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Commit() {
		Connection connection = getConnection();
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void release() {
		Connection connection = getConnection();
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
