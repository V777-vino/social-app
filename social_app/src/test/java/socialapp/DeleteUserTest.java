package socialapp;

import java.util.Scanner;

import socialapp.dao.UserDao;
import socialapp.model.User;
import socialapp.service.UserValidation;

public class DeleteUserTest {
	public static void main(String[] args) throws Exception {
		deleteUserTest();

	}

	public static void deleteUserTest() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mail id");
		String email = sc.next();
		User user = new User();
		user.setEmail(email);
		int a = 0;
		a = UserValidation.deleteUserValidation(user);
		if (a == 1) {
			UserDao.deleteUser(user);
			System.out.println("User deleted successfully");
		}
	}
}
