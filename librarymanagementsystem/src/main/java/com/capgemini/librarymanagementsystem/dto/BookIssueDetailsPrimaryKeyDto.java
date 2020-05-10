package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class BookIssueDetailsPrimaryKeyDto implements Serializable{

	
	private int bookId;

	
	private String email;
}
