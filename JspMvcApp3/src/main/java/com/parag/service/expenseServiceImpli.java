package com.parag.service;

import java.util.List;

import com.parag.dao.expenseDao;
import com.parag.dao.expenseDaoImpli;
import com.parag.modal.Expense;

public class expenseServiceImpli implements expenseService{
	private expenseDao expensedao;

	public expenseServiceImpli() {
		expensedao = new expenseDaoImpli();
	}

	@Override
	public void add(Expense expense) {
		// TODO Auto-generated method stub
		expensedao.save(expense);
		
	}

	@Override
	public List<Expense> getAll(int uid) {
		return expensedao.selectAll(uid);
		
	}

	@Override
	public void removeById(int id) {
		expensedao.deleteById(id);
		
	}

	@Override
	public Expense getById(int id) {
		return expensedao.selectById(id);
	}

	@Override
	public void renew(Expense expense) {
		expensedao.update(expense);
		
	}

	

}
