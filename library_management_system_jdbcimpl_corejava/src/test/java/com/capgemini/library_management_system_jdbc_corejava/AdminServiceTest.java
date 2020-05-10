package com.capgemini.library_management_system_jdbc_corejava;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.dto.AdminDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;

public class AdminServiceTest {

private AdminDao dao = new AdminDaoImplementation();
	
	@Test
	public void testRegisterValid() {
		
		AdminDto dto = new AdminDto();
		dto.setAdminUserId(212121);
		dto.setAdminUserName("Anudeep");
		dto.setAdminEmail("anudeep@gmail.com");
		dto.setAdminPassword("Anudeep@1");
		boolean status = dao.register(dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegisterInvalid() {
		
		AdminDto dto = new AdminDto();
		dto.setAdminUserId(212121);
		dto.setAdminUserName("Anudeep");
		dto.setAdminEmail("anudeep@gmail.com");
		dto.setAdminPassword("Anudeep@1");
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
		
		LinkedList<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertNotNull(searchList);
		
	}

	@Test
	public void testSearchBookTitleInvalid() {
		
		LinkedList<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertEquals(0, searchList.size());
		
	}
	
	@Test
	public void testSearchBookAuthorInvalid() {
		
		LinkedList<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertEquals(0,searchList.size());
	}
	
	@Test
	public void testSearchBookAuthorValid() {
		
		LinkedList<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertNotNull(searchList);
	}
	
	@Test
	public void testSearchBookTypeInvalid() {
		
		LinkedList<BookDto> searchList = dao.searchBookType("Education");
		Assertions.assertEquals(1, searchList.size());
	}
	
	@Test
	public void testSearchBookTypeValid() {
		
		LinkedList<BookDto> searchList = dao.searchBookType("Education");
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
	public void testGetBookIdsValid() {
		
		LinkedList<Integer> idList = dao.getBookIds();
		Assertions.assertNotNull(idList);
	}
	
	@Test
	public void testGetBookIdsInvalid() {
		
		LinkedList<Integer> idList = dao.getBookIds();
		Assertions.assertEquals(0, idList.size());
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
	public void testShowStudentsValid() {
		List<String> list = dao.showStudents();
		Assertions.assertNotNull(list);
		
	}
	
	@Test
	public void testShowStudentsInvalid() {
		List<String> list = dao.showStudents();
		Assertions.assertNotNull(list);
		
	}
	
	@Test
	public void testShowRequestsValid() {
		List<Integer> list = dao.showRequests();
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void testShowRequestsInvalid() {
		List<Integer> list = dao.showRequests();
		Assertions.assertNotNull(list);
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
		boolean status = dao.issueBook(123456,222222);
		Assertions.assertFalse(status);
	}

}
