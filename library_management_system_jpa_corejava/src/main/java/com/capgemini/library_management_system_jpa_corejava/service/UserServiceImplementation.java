package com.capgemini.library_management_system_jpa_corejava.service;

import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dao.UserDao;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;

public class UserServiceImplementation implements UserService {
	
	private UserDao dao=BookFactory.getUserDAO();

	public boolean register(InformationDto std) {

		return dao.register(std);
	}



	public List<BookDto> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public List<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public List<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public List<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean requestBook(int bookId,int userId) {
		// TODO Auto-generated method stub
		return dao.requestBook(bookId, userId);
	}

	@Override
	public boolean returnBook(int userId,int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(bookId, userId);
	}

	
	

}
