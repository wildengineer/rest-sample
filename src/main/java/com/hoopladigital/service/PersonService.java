package com.hoopladigital.service;

import com.hoopladigital.bean.Person;
import com.hoopladigital.mapper.PersonMapper;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

public class PersonService {

	private final PersonMapper personMapper;

	@Inject
	public PersonService(final PersonMapper personMapper) {
		this.personMapper = personMapper;
	}

	public List<Person> getPersonList() {
		return personMapper.getPersonList();
	}

	public Person getPerson(long id) {
		return personMapper.getPersonById(id);
	}

	public Person createPerson(Person person) {
		long id = personMapper.createPerson(person);
		return personMapper.getPersonById(id);
	}

	public Person updatePerson(long id, Person person) {
		Person persisted = personMapper.getPersonById(id);
		if (persisted == null) {
			throw new NotFoundException("Person not found. id=" + id);
		}
		personMapper.updatePerson(person);
		return personMapper.getPersonById(id);
	}

	public void deletePerson(long id) {
		personMapper.deletePerson(id);
	}
}
