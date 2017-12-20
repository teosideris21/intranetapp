package gr.hua.dit.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.Vehicle_card;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User loginUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		User user = (User) currentSession.get(User.class, username);
		return user;

	}

	@Override
	public Vehicle checkDB(String license_plate) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		Vehicle vehicle = (Vehicle) currentSession.get(Vehicle.class, license_plate);
		return vehicle;

	}

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

		// find the customer
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
	
	
	@Override
	public void createCard(Vehicle_card vehicle) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(vehicle.getLicense_plate());
		System.out.println(vehicle.getInspection_date());
		System.out.println(vehicle.getNext_inspection_date());
		System.out.println(vehicle.getModel());
		System.out.println(vehicle.getResults());
		
		// save the customer
		currentSession.save(vehicle);
	}
}
