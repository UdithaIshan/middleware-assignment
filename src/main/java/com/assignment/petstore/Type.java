package com.assignment.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Type")
public class Type {
    @Schema(required = true, description = "Type id")
    @JsonProperty("type_id")
    private Integer typeId;

    @Schema(required = true, description = "Type")
    @JsonProperty("pet_type")
    private String petType;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Type(String petType) {
        this.petType = petType;
    }

    public Type() {
    }

    public Type(Integer typeId, String petType) {
        this.typeId = typeId;
        this.petType = petType;
    }
}
