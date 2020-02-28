package com.springboot.app.celebrityFind;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.celebrityFind.beans.Acquaintances;
import com.springboot.app.celebrityFind.beans.Person;
import com.springboot.app.celebrityFind.factories.CelebrityFactory;

@SpringBootTest
class SpringbootServiceCelebrityFindApplicationTests {

	CelebrityFactory celebrityFactory = new CelebrityFactory();
	private List<Person> testList;
	
	int serverPort = 8001;
	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void initEach(){
	    System.out.println("Before Each initEach() method called");
	}
	
	@Test
    public void testGetPeopleSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+serverPort+"/list/";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("acquaintances"));
    }
	
	@Test
    public void testGetPersonSuccess() throws URISyntaxException 
    {
	  RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+serverPort+"/item/1";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }
	
	
	@Test
    public void testCreatePersonSuccess() throws URISyntaxException 
    {
		RestTemplate restTemplate = new RestTemplate();
		Person person = new Person();
		person.setName("Jorge Alfredo");
	    final String baseUrl = "http://localhost:"+serverPort+"/createPerson";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<Person> result = restTemplate.postForEntity(uri,person, Person.class);
		String nameCreated = result.getBody().getName();
		final String baseUrlList = "http://localhost:"+serverPort+"/list/";
	    URI uriList = new URI(baseUrlList);
	    ResponseEntity<String> resultList = restTemplate.getForEntity(uriList, String.class);
        //Verify request succeed
        Assert.assertEquals(200, resultList.getStatusCodeValue());
        Assert.assertEquals(true, resultList.getBody().contains(nameCreated));
    }
	
	@Test
	public void verifyCelebritySuccess() throws URISyntaxException 
	{
	    int contPerson = 0;
 		int contAcquain = 0;
 		testList = new ArrayList<Person>();
 		List<Acquaintances> listAcquaintances = new ArrayList<Acquaintances>();
 		Person person = new Person();
 		person.setId(1);
 		person.setName("Jorge Alonso");
 		person.setAcquaintances(listAcquaintances);
 		person.setId(contPerson++);
 		testList.add(person);
 		person = new Person();
 		person.setId(1);
 		person.setName("María");
 		listAcquaintances = new ArrayList<Acquaintances>();
 		Acquaintances acquaintances = new Acquaintances();
 		acquaintances.setParentId(contAcquain);
 		acquaintances.setRelatedId(0); // celebrity
 		acquaintances.setId(contAcquain++);
 		listAcquaintances.add(acquaintances);
 		person.setAcquaintances(listAcquaintances);
 		person.setId(contPerson++);
 		testList.add(person);
	 		
		String celebrityId = "";
		try {
			celebrityId = celebrityFactory.getFinder("default").find(testList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Assert.assertEquals(true, celebrityId.equals("0"));
	}
		 
	@Test
	public void verifyCelebrityFailure() throws URISyntaxException 
	{
	    int contPerson = 0;
		int contAcquain = 0;
		testList = new ArrayList<Person>();
		List<Acquaintances> listAcquaintances = new ArrayList<Acquaintances>();
		Person person = new Person();
		person.setId(1);
		person.setName("Jorge Alonso");
		person.setAcquaintances(listAcquaintances);
		person.setId(contPerson++);
		testList.add(person);
		person = new Person();
		person.setId(1);
		person.setName("María");
		listAcquaintances = new ArrayList<Acquaintances>();
		Acquaintances acquaintances = new Acquaintances();
		acquaintances.setParentId(contAcquain);
		acquaintances.setRelatedId(0); // celebrity
		acquaintances.setId(contAcquain++);
		listAcquaintances.add(acquaintances);
		person.setAcquaintances(listAcquaintances);
		person.setId(contPerson++);
		person = new Person();
		person.setId(1);
		person.setName("Camilo");
		listAcquaintances = new ArrayList<Acquaintances>();
		acquaintances = new Acquaintances();
		acquaintances.setParentId(contAcquain);
		acquaintances.setRelatedId(1); // he njoncelebrity
		acquaintances.setId(contAcquain++);
		listAcquaintances.add(acquaintances);
		person.setAcquaintances(listAcquaintances);
		person.setId(contPerson++);
		testList.add(person);
		String celebrityId = "";
		try {
			celebrityId = celebrityFactory.getFinder("default").find(testList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Assert.assertEquals(false, celebrityId.equals("0"));
	}
}
