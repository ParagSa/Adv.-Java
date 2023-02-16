package com.parag.dao;

import com.parag.model.User;

public interface UserDao {
	void save(User user);
	boolean present(User user);

}
