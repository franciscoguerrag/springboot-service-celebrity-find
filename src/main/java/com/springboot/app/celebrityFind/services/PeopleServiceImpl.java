package com.springboot.app.celebrityFind.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.celebrityFind.beans.Person;

@Service
public class PeopleServiceImpl implements IPeopleService {
	
	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Person> findAllPeople() {
		List<Person> people = Arrays.asList(clientRest.getForObject("http://localhost:8001/list", Person[].class));
		return people;
	}

	@GetMapping("item/{id}")
	public Person detail(@PathVariable Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Person person = clientRest.getForObject("http://localhost:8001/item/{id}", Person.class, pathVariables);
		return person;
	}

}
