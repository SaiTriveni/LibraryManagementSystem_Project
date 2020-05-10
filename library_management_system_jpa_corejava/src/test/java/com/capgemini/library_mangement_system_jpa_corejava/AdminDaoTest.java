package com.capgemini.library_mangement_system_jpa_corejava;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.library_management_system_jpa_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jpa_corejava.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_jpa_corejava.dao.UserDao;
import com.capgemini.library_management_system_jpa_corejava.dao.UserDaoImplementation;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public class AdminDaoTest {
private AdminDao dao = new AdminDaoImplementation();
	
	@Test
	public void testRegisterValid() {
		
		InformationDto dto = new InformationDto();
		dto.setId(212121);
		dto.setName("anudeep");
		dto.setEmail("anudeep@gmail.com");
		dto.setPassword("Anudeep@1");
		dto.setTypeOfUser("admin");
		boolean status = dao.register(dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegisterInvalid() {
		
		InformationDto dto = new InformationDto();
		dto.setId(212121);
		dto.setName("anudeep");
		dto.setEmail("anudeep@gmail.com");
		dto.setPassword("Anudeep@1");
		dto.setTypeOfUser("admin");
		boolean status = dao.register(dto);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginValid() {
		
		boolean status = dao.auth("sai@gmail.com","Sai@60498");
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginInvalid() {
		
		boolean status = dao.auth("sai@gmail.com","Sai@160498");
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testAddBookValid() {
		
		
		BookDto dto = new BookDto();
		dto.setBookId(111222);
		dto.setBookTitle("Jspiders");
		dto.setBookAuthor("Sunil");
		dto.setBookType("Education");
		dto.setBookPublisher("SAP Publishers");
		boolean status = dao.addBook(dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testAddBookInvalid() {
		
		BookDto dto = new BookDto();
		dto.setBookId(111222);
		dto.setBookTitle("Jspiders");
		dto.setBookAuthor("Sunil");
		dto.setBookType("Education");
		dto.setBookPublisher("SAP Publishers");
		boolean status = dao.addBook(dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testSearchBookTitleValid() {
		
		List<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertNotNull(searchList);
		
	}

	@Test
	public void testSearchBookTitleInvalid() {
		
		List<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertEquals(0, searchList.size());
		
	}
	
	@Test
	public void testSearchBookAuthorInvalid() {
		
		List<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertEquals(0,searchList.size());
	}
	
	@Test
	public void testSearchBookAuthorValid() {
		
		List<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertNotNull(searchList);
	}
	
	@Test
	public void testSearchBookTypeInvalid() {
		
		List<BookDto> searchList = dao.searchBookType("Education");
		Assertions.assertEquals(1, searchList.size());
	}
	
	@Test
	public void testSearchBookTypeValid() {

		ArrayList<BookDto> searchList = (ArrayList<BookDto>) dao.searchBookType("Education");
		Assertions.assertNotNull(searchList);
	}
	
	@Test
	public void testUpdateValid() {
		
		boolean status = dao.updateBook(111222, "J2SE");
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testUpdateInvalid() {
		
		boolean status = dao.updateBook(111212, "J2SE");
		Assertions.assertFalse(status);
}
	
	
	@Test
	public void testGetBooksInfoValid() {
		
		List<BookDto> list = dao.getBooksInfo();
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void testGetBooksInfoInvalid() {
		
		List<BookDto> list = dao.getBooksInfo();
		Assertions.assertEquals(0, list.size());
	}
	
	@Test
	public void testRemoveBookValid() {
		
		boolean status = dao.removeBook(111222);
		Assertions.assertTrue(status);
	}
	
	
	@Test
	public void testRemoveBookInvalid() {
		
		boolean status = dao.removeBook(111222);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIssueBookValid() {
		UserDao userDao = new UserDaoImplementation();
		boolean requestDto = userDao.requestBook(123456,222222);
		boolean status = dao.issueBook(123456,222222);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIssueBookInvalid() {
		UserDao userDao = new UserDaoImplementation();
		boolean requestDto = userDao.requestBook(123456,222222);
		boolean status = dao.issueBook(123456,222222);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testReturnBookValid() {
		boolean status = dao.returnBook(222222,123456);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testReturnBookInvalid() {
		boolean status = dao.returnBook(222222,123456);
		Assertions.assertFalse(status);
	}

}
