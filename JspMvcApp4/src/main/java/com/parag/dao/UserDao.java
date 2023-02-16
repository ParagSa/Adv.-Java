package com.parag.dao;

import com.parag.modal.User;

public interface UserDao {
	void save(User user);
    boolean login(User user);
    void upload(int uid,String image);
}
