package com.capgemini.library_management_system_jpa_corejava.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jpa_corejava.service.AdminService;
import com.capgemini.library_management_system_jpa_corejava.service.UserService;

public class SearchTypes {

	static
	Scanner scanner = new Scanner(System.in);
	static AdminService service = BookFactory.getAdminService();
	static UserService service1 = BookFactory.getUserService();
	
	public static void searchTitle(String flag) {
		List<BookDto> dto=new LinkedList<BookDto>();
		try {
			System.out.println("Enter the Book Name to Search Books");
			String book_Name = scanner.next();
			BookDto bean4 = new BookDto();
			bean4.setBookTitle(book_Name);
			if (flag.equals("admin")) {
			dto = service.searchBookTitle(book_Name);
			}
			else {
			dto = service1.searchBookTitle(book_Name);
			}
			System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
					"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
			for (BookDto bookDto : dto) {
				if (bookDto != null) {
					System.out.println();
					System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
							bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
							bookDto.getBookType(), bookDto.getBookPublisher()));
				} else {
					System.err.println("No books are present by given book name");
				}
			}
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
		
	}
	
	public static void searchAuthor(String flag) {
		List<BookDto> dto=new LinkedList<BookDto>();
		try {
			System.out.println("Enter the Book Author for required books");
			String book_Author = scanner.next();
			BookDto bean5 = new BookDto();
			bean5.setBookAuthor(book_Author);
			if (flag.contentEquals("admin")) {
			dto = service.searchBookAuthor(book_Author);
			}
			else {
				dto = service1.searchBookAuthor(book_Author);
			}
			System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
					"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
			for (BookDto bookDto : dto) {
				if (bookDto != null) {
					System.out.println();
					System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
							bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
							bookDto.getBookType(), bookDto.getBookPublisher()));
				} else {
					System.err.println("No books are present by given author name");
				}
			}
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
	}
	
	public static void searchType(String flag) {
		List<BookDto> dto=new LinkedList<BookDto>();
		try {
			System.out.println("Enter the Book Type for required books");
			String book_Type = scanner.next();
			BookDto bean6 = new BookDto();
			bean6.setBookType(book_Type);
			if(flag.equals("admin")) {
			dto = service.searchBookType(book_Type);
			}
			else {
				dto = service1.searchBookType(book_Type);
			}
			System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
					"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
			for (BookDto bookDto : dto) {
				if (bookDto != null) {
					System.out.println();
					System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
							bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
							bookDto.getBookType(), bookDto.getBookPublisher()));
				} else {
					System.err.println("No books are present by given Book Type");
				}
			}
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
	}
	
	public static void searchAllBooks(String flag) {
		List<BookDto> dto=new LinkedList<BookDto>();
		try {
			if(flag.contentEquals("admin")) {
			dto = service.getBooksInfo();
			}
			else {
				dto = service1.getBooksInfo();
			}
			System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
					"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
			for (BookDto bookDto : dto) {

				if (bookDto != null) {
					System.out.println();
					System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
							bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
							bookDto.getBookType(), bookDto.getBookPublisher()));
				} else {
					System.err.println("No Books are present");
				}
			}
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
	}

}
