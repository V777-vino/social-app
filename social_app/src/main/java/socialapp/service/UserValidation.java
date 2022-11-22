package socialapp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import socialapp.db.ConnectionUtil;
import socialapp.model.User;

public class UserValidation {
	@SuppressWarnings("finally")
	public static int deleteUserValidation(User user) throws Exception {
		Connection connection = ConnectionUtil.databaseConnection();
		Statement statement = connection.createStatement();
		String query = null;
		String email = null;
		int result = 0;

		try {
			query = "SELECT email,PASSWORD FROM USER WHERE email = '" + user.getEmail() + "'";
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				email = rs.getString("email");
			}

			if (email.equals(user.getEmail())) {
				result = result + 1;
			}

		} catch (Exception e) {
			throw new Exception("This user not registered");
		} finally {
			connection.close();
			return result;
		}

	}

	@SuppressWarnings("finally")
	public static int userDetailsCheck(User user) throws Exception, SQLException {
		Connection connection = ConnectionUtil.databaseConnection();
		Statement statement = connection.createStatement();
		String query = null;
		String email = null;
		int result = 0;

		try {
			query = "SELECT email,PASSWORD FROM USER WHERE email = '" + user.getEmail() + "'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				email = rs.getString("email");
			} else {
				result++;
			}
			if (email != null) {
				throw new Exception("This user already regitered");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
			return result;
		}
	}

	@SuppressWarnings({ "finally" })
	public static int passwordUpdateValidatioin(User user) throws Exception {
		Connection connection = ConnectionUtil.databaseConnection();
		Statement statement = connection.createStatement();
		String query = null;
		String email = null;
		int result = 0;

		try {
			query = "SELECT email,PASSWORD FROM USER WHERE email = '" + user.getEmail() + "'";
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				email = rs.getString("email");
			}

			if (email.equals(user.getEmail())) {
				result = result + 1;
			}

		} catch (Exception e) {
			throw new Exception("This user not registered");
		} finally {
			connection.close();
			return result;
		}

	}

	public static int registerValidation(User user) throws Exception {
		if (user.getName().isBlank() || user.getName().isBlank()) {
			throw new Exception("Name shoul'nt be empty or blank");
		}
		if (user.getMobileNo().length() != 10) {
			throw new Exception("Enter a valid mobile number");
		}
		if (!user.getEmail().contains("@gmail.com")) {
			throw new Exception("Enter a valid mail");
		}
		if (!(user.getPassword().length() >= 5)) {
			throw new Exception("Enter a valid password");
		}
		if (user.getGender() != 'M' && user.getGender() != 'F') {
			throw new Exception("Enter 'M' or 'F'");
		}
		return 1;

	}

}
