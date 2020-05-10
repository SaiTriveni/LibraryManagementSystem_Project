package com.capgemini.librarymanagementsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class LMSResponse {

	private boolean error;
	private String message;
	
	private InformationDto user;
	private List<InformationDto> userBean;
	private BookDto book;
//	private List<Integer> bookBeanId;
	private List<BookDto> bookList;
	private BookIssueDetailsDto bookIssue;
	private RequestDto requestBook;
	private BooksBorrowedDto borrowBook;
	
	
	
	
	
	
	

}
