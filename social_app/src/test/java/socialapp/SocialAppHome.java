package socialapp;

import java.util.Scanner;

public class SocialAppHome {
	public static void main(String[] args) throws Exception {
		home();

	}

	public static void home() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the social app\n");
		System.out.println("1. Register as new user");
		System.out.println("2. Login");
		System.out.println("\nEnter your choice:");
		int num = sc.nextInt();
		if (num == 1) {
			RegisterUserTest.registration();
			home();
		} else if (num == 2) {
			LoginTest.login();
			Menu.menu();
		} else {
			System.out.println("\nInvalid input");
			System.exit(1);
		}
	}

}
