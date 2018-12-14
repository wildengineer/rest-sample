package com.hoopladigital.resource;

import com.hoopladigital.bean.Person;
import com.hoopladigital.bean.Pet;
import com.hoopladigital.service.PetsByOwnerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/people/{personId}/pets")
public class PetsByOwnerResource {

	private final PetsByOwnerService petsByOwnerService;

	@Inject
	public PetsByOwnerResource(final PetsByOwnerService petsByOwnerService) {
		this.petsByOwnerService = petsByOwnerService;
	}

	@GET
	@Produces("application/json")
	public List<Pet> getPetsByPersonId(@PathParam("personId") long personId) {
		return petsByOwnerService.getPetsByPersonId(personId);
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pet getPet(@PathParam("personId") long personId, @PathParam("id") long id) {
		return petsByOwnerService.getPet(id, personId);
	}

	@POST
	@Produces("application/json")
	public Pet createPet(@PathParam("personId") long personId, Pet pet) {
		return petsByOwnerService.createPet(personId, pet);
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public Pet updatePet(@PathParam("personId") long personId, @PathParam("id") long id, Pet pet) {
		return petsByOwnerService.updatePet(personId, id, pet);
	}

	@DELETE
	@Path("/{id}")
	public Response deletePet(@PathParam("personId") long personId, @PathParam("id") long id) {
		petsByOwnerService.deletePet(personId, id);
		return Response.noContent().build();
	}
}
