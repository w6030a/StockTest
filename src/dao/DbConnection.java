package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.IOUtil;

public class DbConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/";
	private static final String DB_NAME = "stocktestdb";
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "abcd"; // is it right?
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("DB class not found!");
		}
	}
	
	public static Connection getConnection() {
		Connection conn= null;
		
		try {
			conn = DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("DB connection failed");
		}
		
		return conn;
	}
	
	public static void closeConnection(ResultSet rs, Statement st, Connection conn) {
		IOUtil.close(rs);
		IOUtil.close(st);
		IOUtil.close(conn);
	}
}
