package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.EncryptionUtil;
import biz.User;

public class DbService {
	
	public void addUser(User user) throws SQLException {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into stocktest.users(username, password, email, regtime) values(?, ?, ?, ?)";
		String timeStamp = String.valueOf(System.currentTimeMillis());
		 
		System.out.println(sql);
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, EncryptionUtil.SaltedEncrypt(user.getPassword(), timeStamp));
		ps.setString(3, user.getEmail());
		ps.setString(4, timeStamp);
		ps.executeUpdate();
	}
	
	public User getUser(String userName, String password) {
		User user = null;
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from stocktest.users where username= ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String registerTime = rs.getString("regtime");
				if(rs.getString("password").equals(EncryptionUtil.SaltedEncrypt(password, registerTime))) {
					user = new User(rs.getString("name"), rs.getString("password"), rs.getString("email"));
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(rs, ps, conn);
		}
		
		return user;
	}
	
	public boolean hasSameName(String userName) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from stocktest.users where username= ?";
		boolean dbAlreadyHasThatUserName = false;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			dbAlreadyHasThatUserName = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dbAlreadyHasThatUserName;
	}
}
