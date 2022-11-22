package socialapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import socialapp.db.ConnectionUtil;
import socialapp.model.User;

public class UserDao {
	public static void deleteUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.databaseConnection();
		String query = " DELETE FROM USER WHERE email='" + user.getEmail() + "'";
		PreparedStatement statement = connection.prepareStatement(query);
		int rows = statement.executeUpdate();
		System.out.println("Profile deleted successfully");

	}

	public static void updatePassword(User user) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtil.databaseConnection();
		String query = "UPDATE USER SET PASSWORD='" + user.getPassword() + "' WHERE email = '" + user.getEmail() + "'";
		PreparedStatement statement = connection.prepareStatement(query);
		int rows = statement.executeUpdate();

	}

	public static int userLogin(String email, String password) throws Exception {
		String name1 = null;
		String email1 = null;
		String password1 = null;

		Connection connection = ConnectionUtil.databaseConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT NAME,email,PASSWORD FROM USER WHERE email='" + email + "' AND PASSWORD='" + password
				+ "'";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			name1 = rs.getString("name");
			email1 = rs.getString("email");
			password1 = rs.getString("password");
		}
		int result = 0;

		if (name1 == null) {
			result = 0;

		} else if (email1 == null) {
			result = 0;
		} else if (password1.equals(password)) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	public static int registerUser(User user) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtil.databaseConnection();
		String query = "insert into user(name,email,mobile_no,password,gender,dob,status)values('" + user.getName()
				+ "','" + user.getEmail() + "','" + user.getMobileNo() + "','" + user.getPassword() + "','"
				+ user.getGender() + "',+'" + user.getDob() + "','" + user.getStatus() + "')";
		PreparedStatement statement = connection.prepareStatement(query);
		int rows = statement.executeUpdate(query);
		System.out.println("Profile created successfully!");
		return rows;
	}

}
