package gr.hua.dit.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.LoginDAO;
import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;

@Service
public class LoginServiceImpl implements LoginService {

	// inject the CustomerDAO
		@Autowired
		private LoginDAO logDao;
		
		@Override
		@Transactional
		public User loginUser(String username) {
			return logDao.loginUser(username);
		}
		
		@Override
		@Transactional
		public Vehicle checkDB(String license_plate) {
			return logDao.checkDB(license_plate);
		}
}