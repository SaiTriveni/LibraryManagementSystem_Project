package com.capgemini.library_management_system_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.capgemini.library_management_system_collections.dao.AdminDao;
import com.capgemini.library_management_system_collections.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_collections.dao.UserDao;
import com.capgemini.library_management_system_collections.dao.UserDaoImplementation;
import com.capgemini.library_management_system_collections.database.Database;
import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;

public class AdminDaoTest {

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
		Database.addToDatabase();
		boolean status = dao.auth("sai@gmail.com","Sai@60498");
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginInvalid() {
		Database.addToDatabase();
		boolean status = dao.auth("sai@gmail.com","Sai@160498");
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testAddBookValid() {
		
		Database.addToDatabase();
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
		
		Database.addToDatabase();
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
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertNotNull(searchList);
		
	}

	@Test
	public void testSearchBookTitleInvalid() {
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookTitle("Java");
		Assertions.assertEquals(0, searchList.size());
		
	}
	
	@Test
	public void testSearchBookAuthorInvalid() {
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertEquals(0,searchList.size());
	}
	
	@Test
	public void testSearchBookAuthorValid() {
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookAuthor("Mr.Sunil");
		Assertions.assertNotNull(searchList);
	}
	
	@Test
	public void testSearchBookTypeInvalid() {
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookType("Education");
		Assertions.assertEquals(1, searchList.size());
	}
	
	@Test
	public void testSearchBookTypeValid() {
		
		Database.addToDatabase();
		ArrayList<BookDto> searchList = dao.searchBookType("Education");
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
		List<UserDto> list = dao.showStudents();
		Assertions.assertNotNull(list);
		
	}
	
	@Test
	public void testShowStudentsInvalid() {
		List<UserDto> list = dao.showStudents();
		Assertions.assertNotNull(list);
		
	}
	
	@Test
	public void testShowRequestsValid() {
		List<RequestDto> list = dao.showRequests();
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void testShowRequestsInvalid() {
		List<RequestDto> list = dao.showRequests();
		Assertions.assertNotNull(list);
	}
	

	@Test
	public void testIssueBookValid() {
		UserDao userDao = new UserDaoImplementation();
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		RequestDto requestDto = userDao.requestBook(userDto, dto);
		boolean status = dao.bookIssue(userDto,dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIssueBookInvalid() {
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		boolean status = dao.bookIssue(userDto,dto);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testIsBookReceivedValid() {
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		boolean status = dao.isBookReceived(userDto, dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testIsBookReceivedInvalid() {
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		boolean status = dao.isBookReceived(userDto, dto);
		Assertions.assertFalse(status);
	}
	
}
