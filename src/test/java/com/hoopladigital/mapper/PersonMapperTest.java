package com.hoopladigital.mapper;

import com.hoopladigital.bean.Person;
import com.hoopladigital.test.AbstractMapperTest;
import org.hamcrest.Matcher;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;

import static com.hoopladigital.mapper.TestDataBuilder.buildPerson;
import static org.junit.Assert.*;

public class PersonMapperTest extends AbstractMapperTest {

	@Inject
	private PersonMapper personMapper;

	@Test
	public void should_get_person_list() throws Exception {

		// setup
		final Person george = buildPerson(1L, "George", "Washington");

		// run test
		final List<Person> personList = personMapper.getPersonList();

		// verify mocks / capture values

		// assert results
		assertEquals(10, personList.size());
		beanTestHelper.diffBeans(george, personList.get(0));
	}

	@Test
	public void should_get_person() throws Exception {
		final Person expected = buildPerson(6L, "John", "Quincy", "Adams");
		final Person actual = personMapper.getPersonById(6L);
		beanTestHelper.diffBeans(expected, actual);
	}

	@Test
	public void should_create_person()  throws Exception {
		final Person expected = buildPerson(11L, "Abe", "Lincoln");
		long id = personMapper.createPerson(expected);
		//Typically here I'd use a jdbc wrapper to read this value raw.
		//TODO: Figure out how to get id back
		assertEquals(11L, id);
		Person actual = personMapper.getPersonById(11L);
		beanTestHelper.diffBeans(expected, actual);
	}

	@Test
	public void should_update_person()  throws Exception {
		final Person expected = buildPerson(6L, "John", "Quincy", "Adams");
		expected.setMiddleName("Q");
		personMapper.updatePerson(expected);
		Person actual = personMapper.getPersonById(6L);
		beanTestHelper.diffBeans(expected, actual);
	}

	@Test
	public void should_delete_person() {
		personMapper.deletePerson(2L);
		Person actual = personMapper.getPersonById(2L);
		assertNull(actual);
	}
}
