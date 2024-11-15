//models/UserDAO.java
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/account";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";

	private Connection getConnection() throws SQLException {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public boolean validateUser(String userId, String password) {
		String sql = "SELECT COUNT(*) FROM ユーザー WHERE id = ? AND pass = ?";
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			stmt.setString(2, password);
			System.out.println(stmt);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePassword(String userId, String newPassword) {
		String sql = "UPDATE ユーザー SET pass = ? WHERE user_id = ?";
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, newPassword);
			stmt.setString(2, userId);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
