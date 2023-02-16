package com.parag.dao;

import java.util.List;

import com.parag.modal.Expense;

public interface expenseDao {
	void save(Expense expense);
	List<Expense> selectAll(int uid);
	void deleteById(int id);
	Expense selectById(int id);
	void update(Expense expense);

}
