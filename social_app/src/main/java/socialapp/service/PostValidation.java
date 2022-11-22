package socialapp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import socialapp.db.ConnectionUtil;
import socialapp.model.Post;

public class PostValidation {
	public static int postDetailsValidation(Post post) throws Exception {

		int result = 0;
		if (post.getId() <= 0) {
			result++;
			throw new Exception("id should not be a negative value");
		}
		if (post.getMessage().isBlank() || post.getMessage().isEmpty()) {
			result++;
			throw new Exception("The post message should not empty or blank");
		}
		Connection connection = ConnectionUtil.databaseConnection();
		Statement statement = connection.createStatement();
		String query = null;
		int id = 0;

		query = "SELECT id,message FROM post WHERE id = '" + post.getId() + "'";
		ResultSet rs = statement.executeQuery(query);

		if (rs.next()) {
			id = rs.getInt("id");
		}

		if (id == post.getId()) {
			result = result + 1;
		}

		return result;
	}

}
