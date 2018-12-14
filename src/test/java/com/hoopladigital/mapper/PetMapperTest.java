package com.hoopladigital.mapper;

import com.hoopladigital.bean.Pet;
import com.hoopladigital.test.AbstractMapperTest;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static com.hoopladigital.mapper.TestDataBuilder.buildPet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PetMapperTest extends AbstractMapperTest {

	@Inject
	private PetMapper petMapper;

	@Test
	public void should_get_pet_list_by_person_id() throws Exception {

		// setup
		final Pet thomas = buildPet(1L , "Thomas", 1L);
		final Pet gage = buildPet(2L , "Gage", 1L);

		// run test
		final List<Pet> petList = petMapper.getPetsByPersonId(1L);

		// assert results
		assertEquals(2, petList.size());
		beanTestHelper.diffBeans(thomas, petList.get(0));
		beanTestHelper.diffBeans(gage, petList.get(1));
	}

	@Test
	public void should_get_pet_by_id() throws Exception {

		// arrange
		final Pet expected = buildPet(4L, "Daisy", 3L);

		// act
		final Pet actual = petMapper.getPetById(4L);

		// assert
		beanTestHelper.diffBeans(expected, actual);
	}

	@Test
	public void should_update_pet() throws Exception {
		// setup
		final Pet lucy = buildPet(3L , "Lucy", 2L);
		lucy.setPersonId(3L);

		// run test
		petMapper.updatePet(lucy);

		List<Pet> petList = petMapper.getPetsByPersonId(3L);
		// assert results
		assertEquals(2, petList.size());
		beanTestHelper.diffBeans(lucy, petList.get(0));
	}

	@Test
	public void should_create_pet() throws Exception {
		// setup
		final Pet sam = buildPet(12L , "Sam", 2L);

		// run test
		petMapper.createPet(sam);

		Pet pet = petMapper.getPetById(12L);
		// assert results
		beanTestHelper.diffBeans(sam, pet);
	}

	@Test
	public void should_delete_pet() throws Exception {
		// run test - delete lucy
		petMapper.deletePet(3L);

		// assert results
		assertNull(petMapper.getPetById(3L));
	}
}
