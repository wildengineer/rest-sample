package com.hoopladigital.mapper;

import com.hoopladigital.bean.Pet;

import java.util.List;

public interface PetMapper {
	List<Pet> getPetsByPersonId(long personId);

	Pet getPetById(long petId);

	long createPet(Pet pet);

	void updatePet(Pet pet);

	void deletePet(long id);
}
