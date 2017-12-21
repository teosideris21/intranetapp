package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Vehicle_card;

@Repository
public class TechnicianDAOImpl implements TechnicianDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createCard(Vehicle_card vehicle) {
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		currentSession.save(vehicle);
	}

}
