package com.assignment.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Pet")
public class Pet {

    @Schema(required = true, description = "Pet id")
    @JsonProperty("pet_id")
    private Integer petId;

    @Schema(required = true, description = "Pet type")
    @JsonProperty("pet_type")
    private Type petType;

    @Schema(required = true, description = "Pet name")
    @JsonProperty("pet_name")
    private String petName;

    @JsonProperty("pet_age")
    private Integer petAge;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Type getPetType() {
        return petType;
    }

    public void setPetType(Type petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public Pet() {
    }

    public Pet(Type petType, String petName, Integer petAge) {
        this.petType = petType;
        this.petName = petName;
        this.petAge = petAge;
    }

    public Pet(Integer petId, Type petType, String petName, Integer petAge) {
        this.petId = petId;
        this.petType = petType;
        this.petName = petName;
        this.petAge = petAge;
    }
}
