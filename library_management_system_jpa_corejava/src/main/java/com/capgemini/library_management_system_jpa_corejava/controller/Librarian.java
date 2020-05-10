package com.capgemini.library_management_system_jpa_corejava.controller;

import java.util.Scanner;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jpa_corejava.service.AdminService;
import com.capgemini.library_management_system_jpa_corejava.service.UserService;
import com.capgemini.library_management_system_jpa_corejava.validation.ValidationAdminStudent;

public class Librarian extends Thread{


	public void performOperations() {

		boolean flag = false;
		boolean flag1 = false;
		boolean check = false;

		AdminService service = BookFactory.getAdminService();
		ValidationAdminStudent validation = new ValidationAdminStudent();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		String role = "";
		do {
			
			do {
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					System.out.println("Enter the role to choose either user or admin");
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					role = scanner.next();
					if ((role.equals("admin")) || (role.equals("user"))) {
						flag = true;
					} else {
						System.err.println("Enter either admin or user only");
						flag = false;
					}
			}while(!flag);


			switch(role) {
			case "admin":
				
				do{
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as Admin");
					System.out.println("Press 2 for Admin Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						check = Registration.register("admin");
						if(check) {
							System.out.println("Admin Registered Successfully");
						} else {
							System.out.println("Admin already registered,kindly login");
						}	

						break;

					case 2:
					do {	
						System.out.println("Enter Admin Email");
						String email = scanner.next();
						System.out.println("Enter Admin Password");
						String password = scanner.next();
						flag1 = service.auth(email, password);
						}while(!flag1);
						try {
							
							System.out.println("Admin Logged in Successfully");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Add Books");
								System.out.println("Press 2 to Update");
								System.out.println("Press 3 to Search Book by Book Name");
								System.out.println("Press 4 to Search Book by Book Author");
								System.out.println("Press 5 to Search Book by Book Type");
								System.out.println("Press 6 to Remove Any Book");
								System.out.println("Press 7 to Get No Of Books Available ");
								System.out.println("Press 8 to Issue a book");
								System.out.println("Press 9 to return a book");
								System.out.println("Press 10 to Go to Main");
								System.out.println("*****************************************");


								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									System.out.println("Enter ID");
									int bookId = scanner.nextInt();
									System.out.println("Enter Book Name");
									String bookName = scanner.next();
									System.out.println("Enter Author");
									String bookAuthor = scanner.next();
									System.out.println("Enter Type");
									String bookCategory = scanner.next();
									System.out.println("Enter Publisher Name");
									String bookPubName = scanner.next();

									BookDto bean2 = new BookDto();
									bean2.setBookId(bookId);	
									bean2.setBookTitle(bookName);
									bean2.setBookType(bookCategory);
									bean2.setBookAuthor(bookAuthor);
									bean2.setBookPublisher(bookPubName);
									flag = service.addBook(bean2);
									if(flag) {
										System.out.println("Book is added successfully");
									} else {
										System.out.println("Book already exist");
									}
									break;
								case 2:
									System.out.println("Enter the Book Id to Update");
									int bookID = scanner.nextInt();
									System.out.println("Enter the Book AUthor to be updated");
									String author = scanner.next();
									flag = service.updateBook(bookID,author);
									if(flag)
									{
									System.out.println("Entered Book is Updated ");
									}
									else
									{
										System.out.println("Entered BookId is not available");
									}

									break;
								case 3:
									SearchTypes.searchTitle("admin");
									break;
								case 4:
									SearchTypes.searchAuthor("admin");
									break;
								case 5:
									SearchTypes.searchType("admin");
									break;

								case 6:
									System.out.println("Enter the book Id to delete any book");
									int book_Id = scanner.nextInt();
									
										flag = service.removeBook(book_Id);
										if(flag)
										{
											System.out.println("Book has been removed successfully");
										}
										else
										{
											System.err.println("Entered book is not available");
										}
									break;

								case 7:
									SearchTypes.searchAllBooks("admin");
									break;

								case 8 :
									System.out.println("Enter Book Id");
									int issueId=scanner.nextInt();
									System.out.println("Enter User Id");
									int userId = scanner.nextInt();
									boolean check4=service.issueBook(issueId,userId);
									if(check4) {
										System.out.println("-----------------------------------------------");
										System.out.println("Book Issued");
									}else {
										System.out.println("-----------------------------------------------");
										System.err.println("Book not issued");
									}
									break;
								case 9 :
									System.out.println("Enter book id");
									int bookId1 = scanner.nextInt();
									System.out.println("Enter user id");
									int userId1 = scanner.nextInt();
									boolean check5 = service.returnBook(userId1, bookId1);
									if(check5 == true) {
										System.out.println("Book Returned");
									}else {
										System.err.println("Book cannot be returned");
									}
									break;

								case 10:
									performOperations();
									break;

								default:
									System.err.println("Invalid Choice");
									break;
								}
							}while(true);
						} catch (Exception e) {
							System.err.println("Invalid Credentials");
						}

						break;
					case 3:
						performOperations();
						break;
					default:
						System.err.println("Invalid Choice");
						break;
					}
				} while(true);

			case "user":
				UserService service1 = BookFactory.getUserService();
				do {
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as Admin");
					System.out.println("Press 2 for Admin Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						
						check = Registration.register("user");
						if(check) {
							System.out.println("User Registered Successfully");
						} else {
							System.out.println("User already registered, Kindly login");
						}
						break;
					case 2:
						do {	
							System.out.println("Enter User Email");
							String email = scanner.next();
							System.out.println("Enter User Password");
							String password = scanner.next();
							flag1 = service.auth(email, password);
							}while(!flag1);
						try {
							
							System.out.println("User Logged in Successfully");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Search Book by Book Name");
								System.out.println("Press 2 to Search Book by Book Author");
								System.out.println("Press 3 to Search Book by Book Id");
								System.out.println("Press 4 to get all books available");
								System.out.println("Press 5 to Request Book ");
								System.out.println("Press 6 to place Return request Book ");
								System.out.println("Press 7 to Go to Main");
								System.out.println("*****************************************");

								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									SearchTypes.searchTitle("user");
									break;
								case 2:
									SearchTypes.searchAuthor("user");
									break;
								case 3:
									SearchTypes.searchType("user");
									break;
								
								case 4:
									SearchTypes.searchAllBooks("user");
									break;
								case 5:
									System.out.println("Enter book id to request :");
									int reqBook = scanner.nextInt();
									System.out.println("Enter user Id :");
									int  reqId = scanner.nextInt();
									boolean book = service1.requestBook(reqBook,reqId);
									if(book == true) {
										System.out.println("Book has been requested successfully");
									}else {
										System.err.println(reqBook+" book was not found in library");
									}	
									break;
								case 6:
									System.out.println("Returning a book:");
									System.out.println("------------------");
									
										
										System.out.println("Enter user id:");
										int returned = scanner.nextInt();
										System.out.println("Enter book id:");
										int book_id = scanner.nextInt();
										boolean returnBook = service1.returnBook(returned, book_id);
										if(returnBook) {
											System.out.println("Book has been returned to library successfully");
										}else {
											System.err.println(book_id+" book cannot returned");
										}
									break;

								case 7:
									performOperations();

								default:
									System.err.println("Invalid Choice");
									break;
								}
							}while(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
					case 3:
						performOperations();
						break;

					default:
						System.err.println("Invalid Role");
					}
				} while(true);
			}
		}while(true);
	}
	
	public void run() {
		System.out.println("-----------------WELCOME TO LIBRARY MANAGEMENT SYSTEM----------------------");
		performOperations();
		}
}





