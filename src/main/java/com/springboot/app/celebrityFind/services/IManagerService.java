package com.springboot.app.celebrityFind.services;

import java.util.List;

import com.springboot.app.celebrityFind.beans.Person;

public interface IManagerService {
	
	public String findCelebrity(List<Person> person) throws Exception;
}
