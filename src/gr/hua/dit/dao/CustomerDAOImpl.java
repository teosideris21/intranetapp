package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", 
				Customer.class);
		
		
		// execute the query and get the results list
		List<Customer> customers = query.getResultList();
				
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Customer
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the customer
		Customer customer = currentSession.get(Customer.class, id);

		
		// delete customer
		currentSession.delete(customer);
	}

}
