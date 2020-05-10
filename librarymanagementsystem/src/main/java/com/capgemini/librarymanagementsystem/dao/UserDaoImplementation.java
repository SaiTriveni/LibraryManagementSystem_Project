package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BookDto;
import com.capgemini.librarymanagementsystem.dto.InformationDto;

@Repository
public class UserDaoImplementation implements UserDao {

	@PersistenceUnit
	EntityManagerFactory factory ;

	EntityManager manager = null;
	EntityTransaction transaction = null;
	List<BookDto> list = null;

	@Override
	public boolean register(InformationDto user) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			System.out.println("User inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public List<BookDto> searchBookTitle(String bookName) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDto b where b.bookTitle=:title";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("title", bookName);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;

	}

	@Override
	public List<BookDto> searchBookAuthor(String bookAuthor) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDto b where b.bookAuthor=:author";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("author", bookAuthor);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;

	}

	@Override
	public List<BookDto> searchBookType(String bookType) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDto b where b.bookType=:type";
			TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
			query.setParameter("type", bookType);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}

		manager.close();
		factory.close();
		return list;

	}

	@Override
	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getBooksInfo() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select b from BookDto b";
		TypedQuery<BookDto> query = manager.createQuery(jpql, BookDto.class);
		List<BookDto> recordList = query.getResultList();
		System.out.println("Info");
		manager.close();
		factory.close();
		return recordList;
	}

	@Override
	public boolean requestBook(int bookId, int userId) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookDto b where b.bookId = :bbid");
			Query s = q.setParameter("bbid", bookId);
			List count = s.getResultList();
			int c = count.size();
			if (c != 0) {

				Query q1 = manager.createQuery("select u.name from InformationDto u where id=:id");
				q1.setParameter("id", userId);
				List qq = q1.getResultList();
				Query q2 = manager.createQuery("select b.bookTitle from BookDto b where bookId=:bid");
				q2.setParameter("bid", bookId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from InformationDto e where id=:id");
				q3.setParameter("id", userId);
				List qq3 = q3.getResultList();
				Query req = manager.createNativeQuery(
						"insert into RequestDto (bookId,email,bookTitle,id,name) values (?,?,?,?,?)");
				req.setParameter(1, bookId);
				req.setParameter(2, qq3.get(0));
				req.setParameter(3, qq1.get(0));
				req.setParameter(4, userId);
				req.setParameter(5, qq.get(0));

				req.executeUpdate();
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return false;

	}

	@Override
	public boolean returnBook(int bookId, int userId) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager
					.createQuery("select b from BooksBorrowedDto b where b. booksBorrowedDtoPrimaryKey.bookId = :bid");
			q.setParameter("bid", bookId);
			List count = q.getResultList();
			int s = count.size();
			if (s >= 0) {
				Query q1 = manager.createQuery("select u.name from InformationDto u where id=:id");
				q1.setParameter("id", userId);
				List qq = q1.getResultList();
				Query q2 = manager.createQuery("select b.bookTitle from BookDto b where b.bookId=:bid");
				q2.setParameter("bid", bookId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from InformationDto e where id=:id");
				q3.setParameter("id", userId);
				List qq3 = q3.getResultList();
				Query req = manager.createNativeQuery(
						"insert into RequestDto (bookId,email,bookTitle,id,name) values (?,?,?,?,?)");
				req.setParameter(1, bookId);
				req.setParameter(2, qq3.get(0));
				req.setParameter(3, qq1.get(0));
				req.setParameter(4, userId);
				req.setParameter(5, qq.get(0));
				int count1 = req.executeUpdate();
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

}