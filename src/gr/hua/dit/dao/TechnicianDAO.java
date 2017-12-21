package gr.hua.dit.dao;

import gr.hua.dit.entity.Vehicle_card;

public interface TechnicianDAO {
	public void createCard(Vehicle_card vehicle);
	
	public void deleteCard(Vehicle_card vehicle);
}
