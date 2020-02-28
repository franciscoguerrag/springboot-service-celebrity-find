package com.springboot.app.celebrityFind.beans;

import java.util.List;

public class Person {
	
	private long id;
	private String name;
	private List<Acquaintances> acquaintances;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Acquaintances> getAcquaintances() {
		return acquaintances;
	}
	public void setAcquaintances(List<Acquaintances> acquaintances) {
		this.acquaintances = acquaintances;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", acquaintances=" + acquaintances + "]";
	}
}
