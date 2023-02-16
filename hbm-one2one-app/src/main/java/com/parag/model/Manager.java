package com.parag.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Manager {
	@Id
	private int id;
	private String name;
	@OneToOne
	@JoinColumn(name = "no",unique = true)
	private dept dept;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public dept getDept() {
		return dept;
	}
	public void setDept(dept dept) {
		this.dept = dept;
	}
	
}
