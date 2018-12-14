package com.hoopladigital.resource;

import com.hoopladigital.bean.Person;
import com.hoopladigital.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/people")
public class PersonResource {

	private final PersonService personService;

	@Inject
	public PersonResource(final PersonService personService) {
		this.personService = personService;
	}

	@GET
	@Produces("application/json")
	public List<Person> getPersonList() {
		return personService.getPersonList();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Person getPerson(@PathParam("id") long id) {
		return personService.getPerson(id);
	}

	@POST
	@Produces("application/json")
	public Person createPerson(Person person) {
		return personService.createPerson(person);
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public Person updatePerson(@PathParam("id") long id, Person person) {
		return personService.updatePerson(id, person);
	}

	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") long id) {
		personService.deletePerson(id);
		return Response.noContent().build();
	}
}
