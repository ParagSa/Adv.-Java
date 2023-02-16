package com.parag.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Category {
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id
	private int id;
	private String name;
	@OneToMany
	@JoinColumn(name = "id")
	private Set<Product> products=new HashSet<Product>();
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
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
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
