package com.capgemini.library_management_system_jpa_corejava.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BookIssueDetailsPrimaryKeyDto implements Serializable{

	@SuppressWarnings("unused")
	private int bookId;

	@SuppressWarnings("unused")
	private String email;
}
