package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.librarymanagementsystem.dto.BookDto;
import com.capgemini.librarymanagementsystem.dto.InformationDto;
import com.capgemini.librarymanagementsystem.dto.LMSResponse;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.UserService;


public class LmsRestController {
	
	

	@Autowired
	AdminService service;
	@Autowired
	UserService service1;

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public LMSResponse addUser(@RequestBody InformationDto bean) {
		boolean isAdded = service.register(bean);
		LMSResponse response = new LMSResponse();
		if (isAdded) {
			response.setMessage("record inserted");
		} else {
			response.setError(true);
			response.setMessage("unable to add");
		}
		return response;
	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LMSResponse authentication(@RequestBody String email, String password) {
		boolean isAdded = service.auth(email, password);
		LMSResponse response = new LMSResponse();
		if (isAdded) {
			response.setMessage("Login succesfull");
		} else {
			response.setError(true);
			response.setMessage("Cannot login");
		}
		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LMSResponse addBook(@RequestBody BookDto bean) {
		boolean isBookAdded = service.addBook(bean);
		LMSResponse response = new LMSResponse();
		if (isBookAdded) {
			response.setMessage("Book added succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be added");
		}
		return response;

	}

	@PutMapping(path = "/bookUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LMSResponse updateBook(@RequestBody int bookId,String bookAuthor) {
		boolean isBookUpdated = service.updateBook(bookId, bookAuthor);
		LMSResponse response = new LMSResponse();
		if (isBookUpdated) {
			response.setMessage("Book updated succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteBook/{bookId} ", produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LMSResponse deleteBook(@PathVariable(name = "bookId") int bookId) {
		boolean isBookDeleted = service.removeBook(bookId);
		LMSResponse response = new LMSResponse();
		if (isBookDeleted) {
			response.setMessage("Book deleted succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be deleted");
		}
		return response;
	}


	@GetMapping(path = "/getBookInfo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBookInfo() {
		List<BookDto> getInfo = service1.getBooksInfo();
		LMSResponse response = new LMSResponse();
		if (getInfo != null && !getInfo.isEmpty()) {
			response.setMessage("Book info found");
			response.setBookList(getInfo);
		} else {
			response.setError(true);
			response.setMessage("No info found in db");
		}
		return response;
	}

	@GetMapping(path = "/getBookByName", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBookByName(String bookTitle) {
		List<BookDto> bean = service.searchBookTitle(bookTitle);
		LMSResponse response = new LMSResponse();
		if (bean != null) {
			response.setMessage("Book info found");
			response.setBookList(bean);
		} else {
			response.setError(true);
			response.setMessage("No info found in db");
		}
		return response;
	}

	@GetMapping(path = "/getBookByAuthor", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBookByAuthor(String bookAuthor) {
		List<BookDto> bean = service.searchBookAuthor(bookAuthor);
		LMSResponse response = new LMSResponse();
		if (bean != null) {
			response.setMessage("Book info found");
			response.setBookList(bean);
		} else {
			response.setError(true);
			response.setMessage("No info found in db");
		}
		return response;
	}

	@GetMapping(path = "/getBookById", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBookType(String bookType) {
		List<BookDto> bean = service.searchBookType(bookType);
		LMSResponse response = new LMSResponse();
		if (bean != null) {
			response.setMessage("Book info found");
			response.setBookList(bean);
		} else {
			response.setError(true);
			response.setMessage("No info found in db");
		}
		return response;
	}

	@GetMapping(path = "/issueBook/{userId}/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse issueBook(@PathVariable(name = "userId") int userId, @PathVariable(name = "bookId") int bookId) {
		boolean isBookIssued = service.issueBook(bookId, userId);
		LMSResponse response = new LMSResponse();
		if (isBookIssued) {
			response.setMessage("Book issued succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be issued");
		}
		return response;
	}

	@GetMapping(path = "/returnBook/{bookId}/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse returnBook(@PathVariable(name = "bookId") int bookId, @PathVariable(name = "userId") int userId) {
		boolean isBookReturned = service.returnBook(userId, bookId);
		LMSResponse response = new LMSResponse();
		if (isBookReturned) {
			response.setMessage("Book returned succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be returned");
		}
		return response;
	}

	@GetMapping(path = "/requestBook/{userId}/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse requestBook(@PathVariable(name = "userId") int userId, @PathVariable(name = "bookId") int bookId) {
		boolean isBookRequested = service1.requestBook(bookId, userId);
		LMSResponse response = new LMSResponse();
		if (isBookRequested) {
			response.setMessage("Book requested succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be requested");
		}
		return response;
	}

	@GetMapping(path = "/returnRequestBook/{userId}/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse returnRequestBook(@PathVariable(name = "userId") int userId,
			@PathVariable(name = "bookId") int bookId) {
		boolean isBookReturnRequested = service1.returnBook(userId, bookId);
		LMSResponse response = new LMSResponse();
		if (isBookReturnRequested) {
			response.setMessage("Book return requested succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot place return request");
		}
		return response;
	}



}
