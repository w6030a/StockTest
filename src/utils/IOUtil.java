package utils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IOUtil {

	public static void close(Closeable resource) {
		try {
			if(resource != null)
				resource.close();
		} catch (IOException e) {
			e.printStackTrace(); //ignored on purpose
		}
	}
	
	public static void close(Statement st) {
		try {
			if(st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace(); //ignored on purpose
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace(); //ignored on purpose
		}
	}

	public static void close(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace(); //ignored on purpose
		}
	}
}
