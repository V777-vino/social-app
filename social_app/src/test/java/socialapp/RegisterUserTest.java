package socialapp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import socialapp.dao.UserDao;
import socialapp.model.User;
import socialapp.service.UserValidation;

public class RegisterUserTest {
	public static void main(String[] args) throws Exception {
		registration();

	}

	public static void registration() throws Exception {
		int a = 0;
		int b = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a name:");
		String name = sc.next();
		System.out.println("Enter a email id:");
		String email = sc.next();
		System.out.println("Enter a mobile number:");
		String mobileNo = sc.next();
		System.out.println("Enter a password:");
		String password = sc.next();
		System.out.println("Enter a gender:");
		Character gender = sc.next().charAt(0);
		System.out.println("Enter a dob:");

		String dob1 = sc.next();
		System.out.println("Enter a status:");
		String status = sc.next();
		LocalDate dob = LocalDate.parse(dob1);

		User user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setMobileNo(mobileNo);
		user.setPassword(password);
		user.setGender(gender);
		user.setDob(dob);
		user.setStatus(status);

		try {
			a = UserValidation.registerValidation(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (a == 1) {

			try {
				UserValidation obj = new UserValidation();
				b = UserValidation.userDetailsCheck(user);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			if (b == 1) {
				UserDao.registerUser(user);
			}

		}

	}
}
