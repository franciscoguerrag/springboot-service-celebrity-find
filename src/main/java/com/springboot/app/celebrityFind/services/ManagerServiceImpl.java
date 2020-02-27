package com.springboot.app.celebrityFind.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.app.celebrityFind.beans.Person;
import com.springboot.app.celebrityFind.factories.CelebrityFactory;


@Service
public class ManagerServiceImpl implements IManagerService {

	@Override
	public String findCelebrity(List<Person> person) throws Exception {
		return new CelebrityFactory().getFinder("default").find(person);
	}

}
