package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.User;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// find the customerSystem
		user = currentSession.get(User.class, user.getUsername());
		// delete customer
		currentSession.delete(user);
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		user = currentSession.get(User.class, user.getUsername());

		user.setUsername("usr");
		user.setPassword("pass");
		user.setName("name");
		user.setSurname("surname");
		user.setRole("role");
		user.setEmail("email");
		// delete customer
		currentSession.update(user);
	}

}
