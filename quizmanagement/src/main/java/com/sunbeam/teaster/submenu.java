package com.sunbeam.teaster;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.Quiz;
import com.sunbeam.entity.Result;
import com.sunbeam.exception.NoQuestionsFoundException;
import com.sunbeam.exception.NoQuizFoundException;
import com.sunbeam.teaster.*;

public class submenu {
	Scanner sc = new Scanner(System.in);
	int choice;

	public void AdminMenu() {

		do {

			System.out.println("1. Create Quiz");
			System.out.println("2. List Quiz");
			System.out.println("3. view Results");
			System.out.println("4. Delete Quiz");
			System.out.println("5. Logout");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				try {
					QuizDaoimpl qdao = new QuizDaoimpl();
					System.out.println("enter quiz title");
					String title = sc.next();

					System.out.println("enter quiz path");
					String path = sc.next();
					qdao.createQuiz(title, path);
				} catch (NoQuestionsFoundException e) {
					System.out.println("Error :" + e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:

				
				try {
					QuizDaoimpl qdao = new QuizDaoimpl();
					System.out.println("List of quiz");
					Set<Quiz> quizes = qdao.listquiz();
					for( Quiz q: quizes) {
						System.out.println(q);
					}
				}
					catch(NoQuizFoundException e) {
						System.out.println("Error:" + e.getMessage());
					}
					catch(Exception e) {
						e.printStackTrace();
					}
						
					break;
				
				
			case 3:
			try {
				QuizDaoimpl qdao = new QuizDaoimpl();
				List<Result> results = qdao.viewResults();
				System.out.println("List of Results");
				for(Result r : results) {
					System.out.println(r);
				}
			}
				catch(NoQuizFoundException e) {
					System.out.println("Error:" + e.getMessage());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				
				
				
				try {
					QuizDaoimpl qdao = new QuizDaoimpl();
					System.out.println("enter quiz id to delete:");
					int id = sc.nextInt();
					
					qdao.deleteQuiz(id);
				} catch(NoQuizFoundException e) {
					System.out.println("Error:" + e.getMessage());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Logged Out Successfully!");
				break;
			default:
				System.out.println("invalid");
			}
		} while (choice != 4);

	}




public void StudentMenu() {
	do {
		System.out.println("1. View Quizes");
		System.out.println("2. Take Quiz");
		System.out.println("3. view Scores");
		System.out.println("4. Logout");
		

		System.out.print("Enter Choice : ");
		choice = sc.nextInt();

	}while (choice != 5);
	
}
}


















