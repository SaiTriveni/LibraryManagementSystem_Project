package com.capgemini.library_management_system_collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.library_management_system_collections.dao.UserDao;
import com.capgemini.library_management_system_collections.dao.UserDaoImplementation;
import com.capgemini.library_management_system_collections.database.Database;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;

public class UserServiceTest {

	private UserDao dao = new UserDaoImplementation();
	
	@Test
	public void testRegisterValid() {
		
		UserDto dto = new UserDto();
		dto.setUserId(555555);
		dto.setUserName("Prabhas");
		dto.setUserEmail("prabhas@gmail.com");
		dto.setUserPassword("Prabhas@1");
		dto.setUserBooksBorrowed(0);
		boolean status = dao.register(dto);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegisterInvalid() {
		
		UserDto dto = new UserDto();
		dto.setUserId(555555);
		dto.setUserName("Prabhas");
		dto.setUserEmail("prabhas@gmail.com");
		dto.setUserPassword("Prabhas@1");
		dto.setUserBooksBorrowed(0);
		boolean status = dao.register(dto);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginValid() {
		
		Database.addToDatabase();
		boolean status = dao.auth("sai@gmail.com","Sai@1234");
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginInvalid() {	
		
		Database.addToDatabase();
		boolean status = dao.auth("sai@gmail.com","Sai@1234");
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
	public void testGetBookIdsValid() {
		
		Database.addToDatabase();
		ArrayList<Integer> idList = dao.getBookIds();
		Assertions.assertNotNull(idList);
	}
	
	@Test
	public void testGetBookIdsInvalid() {
		
		Database.addToDatabase();
		ArrayList<Integer> idList = dao.getBookIds();
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
	public void testRequestBookValid() {
		
		Database.addToDatabase();
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		RequestDto requestDto = dao.requestBook(userDto, dto);
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testRequestBookInvalid() {
		
		Database.addToDatabase();
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		RequestDto requestDto = dao.requestBook(userDto, dto);
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testReturnBookValid() {
		Database.addToDatabase();
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		RequestDto requestDto = dao.returnBook(userDto, dto);
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testReturnBookInvalid() {
		Database.addToDatabase();
		BookDto dto = new BookDto();
		dto.setBookId(123456);
		UserDto userDto = new UserDto();
		userDto.setUserId(222222);
		RequestDto requestDto = dao.returnBook(userDto, dto);
		Assertions.assertNotNull(requestDto);
	}
	
}
