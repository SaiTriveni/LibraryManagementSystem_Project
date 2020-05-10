package com.capgemini.library_mangement_system_jpa_corejava;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.library_management_system_jpa_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jpa_corejava.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_jpa_corejava.dao.UserDao;
import com.capgemini.library_management_system_jpa_corejava.dao.UserDaoImplementation;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDto;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public class UserDaoTest {

private UserDao dao = new UserDaoImplementation();

private AdminDao adminDao = new AdminDaoImplementation();
	
	@Test
	public void testRegisterValid() {
		
		InformationDto dto = new InformationDto();
		dto.setId(212121);
		dto.setName("anudeep");
		dto.setEmail("anudeep@gmail.com");
		dto.setPassword("Anudeep@1");
		dto.setTypeOfUser("user");
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
		dto.setTypeOfUser("user");
		boolean status = dao.register(dto);
		Assertions.assertTrue(status);
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
		
		List<BookDto> searchList = dao.searchBookType("Education");
		Assertions.assertNotNull(searchList);
	}
	
	@Test
	public void testGetBookIdsValid() {
		
		List<Integer> idList = dao.getBookIds();
		Assertions.assertNotNull(idList);
	}
	
	@Test
	public void testGetBookIdsInvalid() {
		
		List<Integer> idList = dao.getBookIds();
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
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testRequestBookInvalid() {
		
		boolean requestDto = dao.requestBook(123456,222222);
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testReturnBookValid() {
		
		boolean requestDto = dao.returnBook(123456,222222);
		Assertions.assertNotNull(requestDto);
	}
	
	@Test
	public void testReturnBookInvalid() {
	
		boolean requestDto = dao.returnBook(123456,222222);
		Assertions.assertNotNull(requestDto);
	}
	
}
