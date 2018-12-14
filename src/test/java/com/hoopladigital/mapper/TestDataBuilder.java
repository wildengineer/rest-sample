package com.hoopladigital.mapper;

import com.hoopladigital.bean.Person;
import com.hoopladigital.bean.Pet;

public class TestDataBuilder {

	private TestDataBuilder() {}

	public static Pet buildPet(long id, String name, long personId) {
		final Pet pet = new Pet();
		pet.setId(id);
		pet.setName(name);
		pet.setPersonId(personId);
		return pet;
	}

	public static Person buildPerson(long id, String firstName, String lastName) {
		final Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return person;
	}

	public static Person buildPerson(long id, String firstName, String middleName, String lastName) {
		final Person person = buildPerson(id, firstName, lastName);
		person.setMiddleName(middleName);
		return person;
	}
}
