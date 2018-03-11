package com.uday.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uday.model.Person;
import com.uday.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {
	
	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
	
	@Override
	@POST
	@Path("/add")
	public Response addPerson(Person p) {
		Response response = new Response();
		if(persons.get(p.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Person already exists");
			return response;
		}
		
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Person findPerson(@PathParam("id") int id) {
		return persons.get(id);
	}

	@Override
	@PUT
	@Path("/update")
	public Response updatePerson(Person p) {
		Response response = new Response();
		
		int id = p.getId();
		persons.put(id, p);
		response.setStatus(true);
		response.setMessage("Person updated successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Person doesn't exist");
			return response;
		}
		
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Successfully removed person");
		return response;
	}

	@Override
	@GET
	@Path("/getAll")
	public List<Person> findAll() {
		List<Person> ps = new ArrayList<Person>();
		
		for(Entry<Integer, Person> entry: persons.entrySet())
			ps.add(entry.getValue());
		return ps;
	}

}
