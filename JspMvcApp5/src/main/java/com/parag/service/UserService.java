package com.parag.service;

import com.parag.modal.User;

public interface UserService {
	void add(User user);
	boolean account(User user);
	void addImage(int uid, String image );

}
