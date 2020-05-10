package com.capgemini.library_management_system_jpa_corejava.service;

import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDao dao=BookFactory.getAdminDao();
	
	public boolean register(InformationDto admin) {
		return dao.register(admin);
	}

	public boolean auth(String email, String password) {

		return dao.auth(email, password);
	}

	public boolean addBook(BookDto book) {
		return dao.addBook(book);
	}

	public List<BookDto> searchBookTitle(String bookTitle) {
		return dao.searchBookTitle(bookTitle);
	}

	public List<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public List<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public boolean updateBook(int bookId,String bookAuthor) {
		return dao.updateBook(bookId, bookAuthor);
	}

	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}



	@Override
	public boolean issueBook(int bookId, int userId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bookId,userId);
	}

	@Override
	public boolean returnBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(userId, bookId);
	}




	

}
