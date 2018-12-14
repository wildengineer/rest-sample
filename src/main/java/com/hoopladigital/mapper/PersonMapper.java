package com.hoopladigital.mapper;

import com.hoopladigital.bean.Person;

import java.util.List;

/**
 * MyBatis Mapper class (DAO) for Person
 */
public interface PersonMapper {
	List<Person> getPersonList();

	Person getPersonById(long id);

	long createPerson(Person person);

	void updatePerson(Person person);

	void deletePerson(long id);
}
