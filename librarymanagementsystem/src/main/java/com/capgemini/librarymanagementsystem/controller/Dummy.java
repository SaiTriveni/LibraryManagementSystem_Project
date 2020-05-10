package com.capgemini.librarymanagementsystem.controller;

import com.capgemini.librarymanagementsystem.dto.BookDto;

public class Dummy {

	public static void main(String[] args) {
		LmsRestController controller=new LmsRestController();
		BookDto bean=new BookDto();
		bean.setBookId(1);
		bean.setBookTitle("jdbc");
		bean.setBookAuthor("Sai");
		bean.setBookType("Akhil");
		bean.setBookPublisher("padma");
	System.out.println("book is already");
	controller.addBook(bean);
		
	}
}
