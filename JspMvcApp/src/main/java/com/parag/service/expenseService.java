package com.parag.service;

import java.util.List;

import com.parag.modal.Expense;

public interface expenseService {
	void add(Expense expense);
	List<Expense> getAll(int uid);

}
