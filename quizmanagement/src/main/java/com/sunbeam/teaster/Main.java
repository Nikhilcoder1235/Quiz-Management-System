package com.sunbeam.teaster;
import com.sunbeam.teaster.submenu;
import java.util.Scanner;

import com.sunbeam.Daoimpl.userDaoimpl;
import com.sunbeam.dao.userDao;

import com.sunbeam.entity.Role;
import com.sunbeam.entity.User;
import com.sunbeam.exception.InvalidInputException;
import com.sunbeam.exception.NoQuestionsFoundException;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		User u = new User();
		userDaoimpl dao=new userDaoimpl();
		submenu smenu= new submenu();
		int choice;

		do {

			System.out.println("\n===== QUIZ APP =====");
			System.out.println("1. Admin Login");
			System.out.println("2. Student Register");
			System.out.println("3. Student Login");
			System.out.println("4. Exit");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.print("Email : ");
				String adminEmail = sc.next();

				System.out.print("Password : ");
				String adminPassword = sc.next();

				try  {

					u = dao.login(adminEmail, adminPassword);

					if (u != null && u.getRole() == Role.ADMIN) {

						System.out.println("Admin Login Successful");
						System.out.println("Welcome " + u.getName());
						
						smenu.AdminMenu();
					 
					} else {
						System.out.println("Invalid Credentials");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
try(userDao dao1 = new userDaoimpl())


{         
	
	User user1 = new User();
	sc.nextLine();
				System.out.print("Name : ");
				user1.setName(sc.next());
                   sc.nextLine();
				System.out.print("Email : ");
				String email = sc.next();
                user1.setEmail(email);
				System.out.print("Password : ");
				String password = sc.next();
                user1.setPassword(password);
				

				user1.setRole(Role.STUDENT);

					int count=dao1.save(user1);

					if (count == 1)
						System.out.println("Registration Successful");
}
catch(InvalidInputException e) {
	System.out.println( "ERROR:"+e.getMessage());
}
				 catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:

				System.out.print("Email : ");
				String studentEmail = sc.next();

				System.out.print("Password : ");
				String studentPassword = sc.next();

				try  {

					u = dao.login(studentEmail, studentPassword);

					if (u != null && u.getRole() == Role.STUDENT) {

						System.out.println("Welcome " + u.getName());
						
						smenu.StudentMenu(u);
					} else {
						System.out.println("Invalid Login");
						
						
					}
					
					
				}
				catch(InvalidInputException e) {
				    System.out.println("ERROR : " + e.getMessage());
				}
				
				
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			
			default:

				System.out.println("Invalid Choice");
			}

		} while (choice != 4);

		sc.close();
	}

	
}