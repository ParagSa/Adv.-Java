package com.parag.model;

import javax.persistence.Entity;

@Entity
public class Clerk extends Employee{
	private float hra;

	public Clerk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clerk(int id, String name, float salary, float hra) {
		super(id, name, salary);
		this.hra = hra;
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	@Override
	public String toString() {
		return super.toString()+" " + hra;
	}

	
}
