package com.capgemini.library_management_system_jpa_corejava.dao;

import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public interface AdminDao {
	
	boolean register(InformationDto admin);
	boolean auth(String email,String password);
	boolean addBook(BookDto book);
	List<BookDto> searchBookTitle(String bookTitle);
	List<BookDto> searchBookAuthor(String bookAuthor);
	List<BookDto> searchBookType(String bookType);
	boolean updateBook(int bookId,String bookAuthor);
	boolean removeBook(int bookId);
	List<BookDto> getBooksInfo();

	boolean issueBook(int bookId, int userId);
	boolean returnBook(int userId, int bookId);
	
}
