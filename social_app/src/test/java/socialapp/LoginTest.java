package socialapp;

import java.util.Scanner;

import socialapp.dao.UserDao;
import socialapp.model.User;



public class LoginTest {
	public static void main(String[] args) throws Exception {
		login();

	}
	public static void login() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Email id");
		String email = sc.next();
		System.out.println("Enter a password");
		String password = sc.next();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		int a = UserDao.userLogin(email, password);
		if (a == 1) {
			System.out.println("loggedin succesfully");
		} else if (a == -1) {
			System.out.println("Invalid credentials");
		} else if (a == 0) {
			System.out.println("no user found");
		}
	}

}
