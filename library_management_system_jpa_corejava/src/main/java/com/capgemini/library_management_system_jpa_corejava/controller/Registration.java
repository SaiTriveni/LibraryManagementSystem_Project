package com.capgemini.library_management_system_jpa_corejava.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.exception.JpaException;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jpa_corejava.service.AdminService;
import com.capgemini.library_management_system_jpa_corejava.service.UserService;
import com.capgemini.library_management_system_jpa_corejava.validation.ValidationAdminStudent;

public class Registration 
{
	public static boolean register(String roleType) {

		ValidationAdminStudent validation = new ValidationAdminStudent();
		AdminService service = BookFactory.getAdminService();
		UserService service1 = BookFactory.getUserService();
		@SuppressWarnings("resource")
		Scanner scanner1 = new Scanner(System.in);
		boolean flag = false;
		boolean check = false;
		int regId = 0;
		String regName = null;
		String regEmail = null;
		String regPassword = null;
		String role = "";
		
		do {
			try {
				System.out.println("Enter ID :");
				regId = scanner1.nextInt();
				validation.validatedId(regId);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered Id should contains only digits");
			} catch (JpaException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter Name :");
				regName = scanner1.next();
				validation.validatedName(regName);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered Name should contains only Alphabates");
			} catch (JpaException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter EmailId :");
				regEmail = scanner1.next();
				validation.validatedEmail(regEmail);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered EmailId should be proper of format like xxxxxx@xxxx.com ");
			} catch (JpaException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter Password :");
				regPassword = scanner1.next();
				validation.validatedPassword(regPassword);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Enter Password with a proper format");
			} catch (JpaException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		if(roleType.equals("admin")) {
			InformationDto adminDto=new InformationDto();
			adminDto.setTypeOfUser(roleType);
			adminDto.setId(regId);
			adminDto.setName(regName);
			adminDto.setEmail(regEmail);
			adminDto.setPassword(regPassword);
			check = service.register(adminDto);
		}
		else {
			InformationDto user=new InformationDto();
			user.setTypeOfUser(roleType);
			user.setId(regId);
			user.setName(regName);
			user.setEmail(regEmail);
			user.setPassword(regPassword);
			check = service1.register(user);
		}
		return check;
	}
}
