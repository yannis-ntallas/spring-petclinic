package com.springframework.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{


    private String name;
    private PetType petType;
    private Owner Owner;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public com.springframework.petclinic.model.Owner getOwner() {
        return Owner;
    }

    public void setOwner(com.springframework.petclinic.model.Owner owner) {
        Owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
