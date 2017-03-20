package com.sda.rest.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.rest.HibernateSession;
import com.sda.rest.model.Message;
import com.sda.rest.model.User;

public class ChatUsersService {

	public ChatUsersService() {
		// TODO Auto-generated constructor stub
	}

	public List<User> getUsers() {
		List<User> returnList = new LinkedList<>();

		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			Transaction t = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);

			returnList.addAll(criteria.list());

			t.commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return returnList;
	}
}
