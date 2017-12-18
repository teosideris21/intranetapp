package gr.hua.dit.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.User;



@Repository
public  class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public User loginUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		User user = (User) currentSession.get(User.class, username);
		return user;
		
	}
}
