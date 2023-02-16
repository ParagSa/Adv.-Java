package com.parag.service;

import com.parag.dao.UserDao;
import com.parag.dao.UserDaoImpli;
import com.parag.model.User;

public class UserServiceImpli implements UserService {
	private UserDao userdao;

	public UserServiceImpli(){
		userdao = new UserDaoImpli();
	}

	@Override
	public void register(User user) {
		userdao.save(user);
		
		
	}

}
