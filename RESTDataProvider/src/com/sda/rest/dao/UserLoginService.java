package com.sda.rest.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sda.rest.HibernateSession;
import com.sda.rest.model.LOGIN_RESULT;
import com.sda.rest.model.Message;
import com.sda.rest.model.User;

public class UserLoginService {
	public UserLoginService() {

	}

	public LOGIN_RESULT tryLogin(String login, String password) {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(User.class);
			User result = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();

			if (result != null) {
				if (result.getPassword_hash().equals(password)) {
					return LOGIN_RESULT.SUCCESS;
				} else {
					return LOGIN_RESULT.WRONG_PASSWORD;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return LOGIN_RESULT.GENERAL_FAILURE;
		} finally {
			t.commit();
			if (session != null) {
				session.close();
			}
		}

		return LOGIN_RESULT.USER_DOES_NOT_EXIST;
	}

	public void register(String login, String password) {
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(new User(login, password));

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
