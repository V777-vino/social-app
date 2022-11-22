package socialapp;

import java.util.Scanner;

import socialapp.dao.UserDao;
import socialapp.model.User;
import socialapp.service.UserValidation;


public class UpdatePasswordTest {
	public static void main(String[] args) throws Exception {
		passwordUpdate();
	}

	public static void passwordUpdate() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your new password");
		String password = sc.next();
		System.out.println("Enter your mail id");
		String email = sc.next();
		User user = new User();
		user.setPassword(password);
		user.setEmail(email);

		int a = 0;
		try {
			a = UserValidation.passwordUpdateValidatioin(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (a == 1) {
			UserDao.updatePassword(user);
			System.out.println("password updated successfully");
		}
	}

}
