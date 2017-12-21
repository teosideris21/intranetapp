package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Vehicle;

@Repository
public class SecretariatDAOImpl implements SecretariatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Vehicle checkDB(String license_plate) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		Vehicle vehicle = (Vehicle) currentSession.get(Vehicle.class, license_plate);
		return vehicle;

	}

}
