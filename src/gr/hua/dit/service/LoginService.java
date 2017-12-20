package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.Vehicle_card;

public interface LoginService {
	
	public List<User> getCustomers();
	
	public User loginUser(String username);
	
	public Vehicle checkDB(String license_plate);
	
	public void saveUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public void createCard(Vehicle_card vehicle);
}
