package com.parag.service;

import com.parag.dao.UserDao;
import com.parag.dao.UserDaoImpli;
import com.parag.dao.expenseDao;
import com.parag.dao.expenseDaoImpli;
import com.parag.modal.User;

public class UserServiceImpli implements UserService{
	private UserDao userdao;

	public UserServiceImpli(){
		userdao = new UserDaoImpli();
	}

	@Override
	public void add(User user) {
		userdao.save(user);
		
	}

	@Override
	public boolean account(User user) {
	     return userdao.login(user);
	}

	@Override
	public void addImage(int uid, String image) {
		userdao.upload(uid, image);
		
	}

}
