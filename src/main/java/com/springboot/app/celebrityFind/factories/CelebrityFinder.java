package com.springboot.app.celebrityFind.factories;

import java.util.List;

import com.springboot.app.celebrityFind.beans.Person;

public abstract class CelebrityFinder {
	
	public abstract String find(List<Person> person) throws Exception;

}
