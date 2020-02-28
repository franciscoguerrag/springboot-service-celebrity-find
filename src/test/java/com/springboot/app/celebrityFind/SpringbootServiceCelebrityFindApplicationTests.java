package com.springboot.app.celebrityFind;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.celebrityFind.beans.Person;


@SpringBootTest
class SpringbootServiceCelebrityFindApplicationTests {

	int serverPort = 8001;
	@Test
	void contextLoads() {
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
		  
	
}
