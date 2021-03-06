package gr.hua.dit.service;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.Vehicle_card;

public interface UserService {

	public Vehicle checkDB(String license_plate);

	public void saveUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public void createCard(Vehicle_card vehicle);
	
	public void deleteCard(Vehicle_card vehicle);

}
