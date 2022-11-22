package socialapp;

import java.util.Scanner;

import socialapp.dao.PostDao;
import socialapp.model.Post;
import socialapp.service.PostValidation;

public class PostMessageTest {
	public static void main(String[] args) throws Exception {
		postMessage();

	}

	public static void postMessage() throws Exception {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int a = 0;
		System.out.println("Enter a user id:");
		int id = sc.nextInt();
		System.out.println("Enter a message:");
		String message = sc1.nextLine();

		Post post = new Post();
		post.setId(id);
		post.setMessage(message);
		a = PostValidation.postDetailsValidation(post);
		if (a == 0) {

			PostDao.postMessage(post);
			System.out.println("Message posted successfully");

		} else {
			System.out.println("there is an error in id or message");
		}

	}

}
