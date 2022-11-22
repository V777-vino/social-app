package socialapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import socialapp.db.ConnectionUtil;
import socialapp.model.Post;
import socialapp.model.View;

public class PostDao {

	public static void viewAllPost() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.databaseConnection();

		try {

			String query = " SELECT post.id,user.name,post.message,user.status,user.created_date,post.posted_date FROM USER INNER JOIN post ON user.id = post.id";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			View view = null;
			ArrayList<View> obj = new ArrayList<View>();
			while (rs.next()) {
				view = new View();
				view.setId(rs.getInt("id"));
				view.setName(rs.getString("name"));
				view.setMessage(rs.getString("message"));
				view.setStatus(rs.getString("status"));
				view.setCreatedDate(LocalDate.parse(rs.getString("created_date")));
				view.setPostedDate(LocalDate.parse(rs.getString("posted_date")));

				obj.add(view);

			}
			view.print(obj);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
	}

	public static int postMessage(Post post) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.databaseConnection();
		String query = "INSERT INTO post(id,message) VALUES ('" + post.getId() + "','" + post.getMessage() + "')";
		PreparedStatement statement = connection.prepareStatement(query);
		int rows = statement.executeUpdate();
		return rows;

	}

}
