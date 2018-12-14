package com.hoopladigital.service;

import com.hoopladigital.bean.Person;
import com.hoopladigital.bean.Pet;
import com.hoopladigital.mapper.PersonMapper;
import com.hoopladigital.mapper.PetMapper;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

public class PetsByOwnerService {

	private final PersonMapper personMapper;
	private final PetMapper petMapper;

	@Inject
	public PetsByOwnerService(final PetMapper petMapper, final PersonMapper personMapper) {
		this.personMapper = personMapper;
		this.petMapper = petMapper;
	}

	public List<Pet> getPetsByPersonId(long personId) {
		validatePersonId(personId);
		return petMapper.getPetsByPersonId(personId);
	}

	public Pet getPet(long id, long personId) {
		validatePersonId(personId);
		return petMapper
				.getPetsByPersonId(personId)
				.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElseThrow(() -> new NotFoundException("Pet with id:" + id + " not found"));
	}

	public Pet createPet(long personId, Pet pet) {
		validatePersonId(personId);
		long id = petMapper.createPet(pet);
		return petMapper.getPetById(id);
	}

	public Pet updatePet(long personId, long id, Pet pet) {
		validatePersonId(personId);
		validatePetId(id);
		pet.setId(id);
		petMapper.updatePet(pet);
		return petMapper.getPetById(id);
	}

	public void deletePet(long personId, long id) {
		validatePersonId(personId);
		validatePetId(id);
		petMapper.deletePet(id);
	}

	private void validatePersonId(long personId) {
		Person person = personMapper.getPersonById(personId);
		if (person == null) {
			throw new NotFoundException("Person with id " + personId + " not found");
		}
	}

	private void validatePetId(long petId) {
		Pet pet = petMapper.getPetById(petId);
		if (pet == null) {
			throw new NotFoundException("Person with id " + petId + " not found");
		}
	}
}
