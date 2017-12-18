package gr.hua.dit.dao;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;


public interface LoginDAO {

	public User loginUser(String username);
	
	public Vehicle checkDB(String license_plate);
}
