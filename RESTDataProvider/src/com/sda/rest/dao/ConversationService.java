package com.sda.rest.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sda.rest.HibernateSession;
import com.sda.rest.model.Message;
import com.sda.rest.model.User;

public class ConversationService {

	public ConversationService() {
		// TODO Auto-generated constructor stub
	}

	public List<Message> getConversationBetweenUsers(int sender_id, int recipient_id) {
		List<Message> returnList = new LinkedList<>();

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Message.class);

			returnList.addAll(criteria.add(Restrictions.eq("sender_id", sender_id))
					.add(Restrictions.eq("recipient_id", recipient_id)).list());

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			t.commit();
			if (session != null) {
				session.close();
			}
		}

		return returnList;
	}

	public boolean sendMessage(int sender_id, int recipient_id, String content) {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {

			Message m = new Message(content, sender_id, recipient_id);
			session.save(m);

			return true;
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			t.commit();
			if (session != null) {
				session.close();
			}
		}

		return false;
	}

	public List<Message> getUnreadMessages(int sender_id, int recipient_id) {
		List<Message> returnList = new LinkedList<>();

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Message.class);

			returnList.addAll(criteria.add(Restrictions.eq("sender_id", sender_id))
					.add(Restrictions.eq("recipient_id", recipient_id)).add(Restrictions.eq("status", 0)).list());

			for (Message m : returnList) {
				m.setStatus(1);
				session.update(m);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			t.commit();
			if (session != null) {
				session.close();
			}
		}

		return returnList;
	}
}
