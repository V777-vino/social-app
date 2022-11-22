package socialapp;

import java.sql.SQLException;

import socialapp.dao.PostDao;

public class ViewAllPostTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		viewAllPost();

	}

	public static void viewAllPost() throws ClassNotFoundException, SQLException {
		PostDao.viewAllPost();

	}
}
