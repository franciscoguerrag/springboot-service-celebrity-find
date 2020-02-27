package com.springboot.app.celebrityFind.services;

import java.util.List;

import com.springboot.app.celebrityFind.beans.Person;

public interface IPeopleService {
	
	public List<Person> findAllPeople();
	public Person detail(Long id);
}
