package com.uday.service;

import java.util.List;

import com.uday.model.Person;
import com.uday.model.Response;

public interface PersonService {
	
	//create
	Response addPerson(Person p);
	
	//read
	Person findPerson(int id);
	
	//update
	Response updatePerson(Person p);
	
	//delete
	Response deletePerson(int id);
	
	//list all
	List<Person> findAll();
}
