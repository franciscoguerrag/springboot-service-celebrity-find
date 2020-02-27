package com.springboot.app.celebrityFind.factories;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.app.celebrityFind.beans.Acquaintances;
import com.springboot.app.celebrityFind.beans.Person;

public class CelebrityFinderCollection extends CelebrityFinder{

	@Override
	public String find(List<Person> person) throws Exception {
		
		long sizeTeam = person.size() - 1;
		try {
			return	this.getAcquaintances(person)
					.stream()
					.map(Acquaintances::getRelatedId)
					.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
					.entrySet()
					.stream().filter(e-> e.getValue().equals(sizeTeam))
					.map(e-> e.getKey())
					.findAny().get().toString();
		}
		catch (Exception e) {
			 throw e;
		}
		
	}
	
	/**
	 * Method for getting Acquaintances
	 * @param person
	 * @return
	 */
	public List<Acquaintances> getAcquaintances(List<Person> person) {
		List<Acquaintances> listAcquaintances = person
				.stream()
				.flatMap(p -> p.getAcquaintances().stream())
				.collect(Collectors.toList());
		return listAcquaintances;
	}
	
	
	
}
