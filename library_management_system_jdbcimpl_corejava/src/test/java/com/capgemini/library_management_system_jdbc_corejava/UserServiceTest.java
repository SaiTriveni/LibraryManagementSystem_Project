package com.capgemini.library_management_system_jdbc_corejava;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.UserDto;

public class UserServiceTest {

	private UserDao dao = new UserDaoImplementation();
	private AdminDao adminDao = new AdminDaoImplementation();
		
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
			
			boolean status = adminDao.auth("sai@gmail.com","Sai@1234");
			Assertions.assertFalse(status);
		}
		
		@Test
		public void testLoginInvalid() {	
			
			
			boolean status = adminDao.auth("sai@gmail.com","Sai@1234");
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
		public void testRequestBookValid() {
			
			boolean requestDto = dao.requestBook(123456,222222);
			Assertions.assertTrue(requestDto);
		}
		
		@Test
		public void testRequestBookInvalid() {
			
			
			BookDto dto = new BookDto();
			dto.setBookId(123456);
			UserDto userDto = new UserDto();
			userDto.setUserId(222222);
			boolean requestDto = dao.requestBook(123456,222222);
			Assertions.assertFalse(requestDto);
		}
		
		@Test
		public void testReturnBookValid() {
			
			BookDto dto = new BookDto();
			dto.setBookId(123456);
			UserDto userDto = new UserDto();
			userDto.setUserId(222222);
			boolean requestDto = dao.returnBook(123456,222222);
			Assertions.assertTrue(requestDto);
		}
		
		@Test
		public void testReturnBookInvalid() {
			
			BookDto dto = new BookDto();
			dto.setBookId(123456);
			UserDto userDto = new UserDto();
			userDto.setUserId(222222);
			boolean requestDto = dao.returnBook(123456,222222);
			Assertions.assertFalse(requestDto);
		}

	
}
