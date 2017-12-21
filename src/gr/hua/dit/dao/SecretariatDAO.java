package gr.hua.dit.dao;

import gr.hua.dit.entity.Vehicle;

public interface SecretariatDAO {

	public Vehicle checkDB(String license_plate);
}
