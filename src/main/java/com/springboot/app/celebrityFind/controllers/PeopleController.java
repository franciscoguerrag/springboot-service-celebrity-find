package com.springboot.app.celebrityFind.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.celebrityFind.beans.Person;
import com.springboot.app.celebrityFind.factories.CelebrityFactory;
import com.springboot.app.celebrityFind.services.IPeopleService;

@RestController
public class PeopleController {
	
	public static Logger log = LoggerFactory.getLogger(PeopleController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IPeopleService iPeopleService;
	
	@GetMapping("/findCelebrity")
	public String listPeople() {
		List<Person> people = iPeopleService.findAllPeople();
		CelebrityFactory celebrityFactory = new CelebrityFactory();
		try {
			String celebrityId = celebrityFactory.getFinder(env.getProperty("solutionType")).find(people);
			return iPeopleService.detail(Long.valueOf(celebrityId).longValue()).getName();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
