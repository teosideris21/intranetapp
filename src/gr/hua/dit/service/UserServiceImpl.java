package gr.hua.dit.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.hua.dit.dao.AdminDAO;
import gr.hua.dit.dao.SecretariatDAO;
import gr.hua.dit.dao.TechnicianDAO;
import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.Vehicle_card;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private SecretariatDAO secrDao;

	@Autowired
	private TechnicianDAO techDao;

	@Override
	@Transactional
	public Vehicle checkDB(String license_plate) {
		return secrDao.checkDB(license_plate);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		adminDao.saveUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		adminDao.deleteUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		adminDao.updateUser(user);
	}

	@Override
	@Transactional
	public void createCard(Vehicle_card vehicle) {
		techDao.createCard(vehicle);
	}
}
