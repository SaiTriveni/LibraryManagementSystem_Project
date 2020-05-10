package com.capgemini.library_management_system_jpa_corejava.dao;

import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public interface UserDao {
	boolean register(InformationDto std);
	List<BookDto> searchBookTitle(String bookName);
	List<BookDto> searchBookAuthor(String bookAuthor);
	List<BookDto> searchBookType(String bookType);
	List<Integer> getBookIds();
	List<BookDto> getBooksInfo();
	boolean requestBook(int bookId,int userId);
	boolean returnBook(int bookId,int userId);
	
	

}
