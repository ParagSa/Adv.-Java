package com.parag.service;

import com.parag.dao.MyDao;

public class MyService {
	private MyDao myDao;

	public MyDao getMyDao() {
		return myDao;
	}

	public void setMyDao(MyDao myDao) {
		System.out.println("setDao() called");
		this.myDao = myDao;
	}
	public void add() {
		System.out.println("add() called");
		myDao.save();
	}
	

}
