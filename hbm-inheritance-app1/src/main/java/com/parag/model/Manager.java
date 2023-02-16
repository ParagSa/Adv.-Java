package com.parag.model;

import javax.persistence.Entity;

@Entity
public class Manager extends Employee {
	private float ta;
	private float da;
	public Manager(int id, String name, float salary, float ta, float da) {
		super(id, name, salary);
		this.ta = ta;
		this.da = da;
	}
	public Manager() {
		
	}
	public float getTa() {
		return ta;
	}
	public void setTa(float ta) {
		this.ta = ta;
	}
	public float getDa() {
		return da;
	}
	public void setDa(float da) {
		this.da = da;
	}
	@Override
	public String toString() {
		return super.toString()+"" + ta + " " + da;
	}
	

}
