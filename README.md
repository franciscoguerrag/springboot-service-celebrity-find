# springboot-service-celebrity-find

Spring Boot application for finding a celebrity in a team of n people

## Diagram

![alt text](https://github.com/franciscoguerrag/springboot-service-celebrity-people/blob/master/celebrityDiagram.png)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

For building and running the application you need:

Java 8 ++
Maven 3
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.springboot.app.celebrityFind.SpringbootServiceCelebrityFindApplication` class from your IDE.


- Select the project and run as Spring Boot APP.

or

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)

The server port for the application by default is 9001
You can change it in Application.properties.

### URLs

|  URL |  Method | Response |
|----------|--------------|--------------|
|`http://localhost:9001/findCelebrity`                           | GET | No value present / Celebrity Name|

## Running the tests

Run test SpringbootServiceCelebrityFindApplicationTests

- testGetPeopleSuccess
- testGetPersonSuccess
- testCreatePersonSuccess
- verifyCelebritySuccess
- verifyCelebrityFailure

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## Authors

* **Francisco Guerra** 