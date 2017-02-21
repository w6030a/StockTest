package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.EncryptionUtil;
import biz.User;

public class DbService {
	
	public void addUser(User user) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into User(name, password, email, regtime) values(?, ?, ?, ?)";
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, EncryptionUtil.SaltedEncrypt(user.getPassword(), timeStamp.toString()));
			ps.setString(3, user.getEmail());
			ps.setString(4, timeStamp.toString());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUser(String userName, String password) {
		User user = null;
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from  User where name= ?";

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
		//TODO:
		return false;
	}
}
