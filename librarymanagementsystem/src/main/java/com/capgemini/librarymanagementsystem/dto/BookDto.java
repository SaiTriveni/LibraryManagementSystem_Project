package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="Book")
public class BookDto {
	@Id
	@Column(name="Book_Id")
	private int bookId;
	@Column(name="Book_Title")
	private String bookTitle;
	@Column(name="Book_Author")
	private String bookAuthor;
	@Column(name="Book_Type")
	private String bookType;
	@Column(name="Book_publisher")
	private String bookPublisher;
}
