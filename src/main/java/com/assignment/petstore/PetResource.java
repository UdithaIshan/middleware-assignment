package com.assignment.petstore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {

    private final List<Pet> pets = new ArrayList<>();
    private final List<Type> types = new ArrayList<>();

    public PetResource() {
        types.add(new Type(1, "Dog"));
        pets.add(new Pet(1, types.get(0), "Banti", 3));
        pets.add(new Pet(2, types.get(0), "Tubby", 3));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Pet pet) {
        int index = pets.size();
        int typeId = types.stream()
                .filter(a -> Objects.equals(a.getPetType().toLowerCase(), pet.getPetType().getPetType().toLowerCase())).collect(Collectors.toList()).get(0).getTypeId();
        pet.getPetType().setTypeId(typeId);
        pet.setPetId(++index);
        pets.add(pet);
        return Response.ok(pet).status(201).build();
    }

    @GET
    public Response getPets() {
        return Response.ok(pets).build();
    }

    @GET
    @Path("{petId}")
    public Response getPet(@PathParam("petId") int petId) {
        try {
            return Response.ok(pets.get(petId - 1)).build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{petId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response updatePet(@PathParam("petId") int petId, Pet pet) {
        try {
            pet.setPetId(petId);
            int typeId = types.stream()
                    .filter(a -> Objects.equals(a.getPetType().toLowerCase(), pet.getPetType().getPetType().toLowerCase())).collect(Collectors.toList()).get(0).getTypeId();
            pet.getPetType().setTypeId(typeId);
            pets.set(petId - 1, pet);
            return Response.ok(pet).build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{petId}")
    public  Response deletePet(@PathParam("petId") int petId) {
        try {
            pets.remove(petId - 1);
            return Response.ok().build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/q")
    public Response search(@QueryParam("name") String name, @QueryParam("age") int age, @QueryParam("type") String type) {
        List<Pet> result = new ArrayList<>();

        if (name != null) {
            result = pets.stream()
                    .filter(a -> Objects.equals(a.getPetName().toLowerCase(), name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (age > 0) {
            result = result.stream()
                    .filter(a -> Objects.equals(a.getPetAge(), age))
                    .collect(Collectors.toList());
        }
        if(type != null) {
            result = result.stream()
                    .filter(a -> Objects.equals(a.getPetType().getPetType().toLowerCase(), type.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return Response.ok(result).build();
    }

//  For types

    @POST
    @Path("/types")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addType(Type type) {
        int index = types.size();
        type.setTypeId(++index);
        types.add(type);
        return Response.ok(type).build();
    }

    @GET
    @Path("/types")
    public Response getTypes() {
        return Response.ok(types).build();
    }

    @GET
    @Path("/types/{typeId}")
    public Response getType(@PathParam("typeId") int typeId) {
        try {
            return Response.ok(types.get(typeId - 1)).build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/types/{typeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response updateType(@PathParam("typeId") int typeId, Type type) {
        try {
            type.setTypeId(typeId);
            types.set(typeId - 1, type);
            return Response.ok(type).build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/types/{typeId}")
    public  Response deleteType(@PathParam("typeId") int typeId) {
        try {
            types.remove(typeId - 1);
            return Response.ok().build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}