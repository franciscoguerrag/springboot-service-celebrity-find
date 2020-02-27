package com.springboot.app.celebrityFind.factories;

public class CelebrityFactory {
	public CelebrityFinder getFinder(String tipo) {
		 if (tipo.equals("default")) {
			 return new CelebrityFinderCollection();
		 }
		return null;	
	}
}