package gr.hua.dit.service;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;

public interface LoginService {
	public User loginUser(String username);
	
	public Vehicle checkDB(String license_plate);
}
