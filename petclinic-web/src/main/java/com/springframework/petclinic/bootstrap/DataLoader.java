package com.springframework.petclinic.bootstrap;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Speciality;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.OwnerService;
import com.springframework.petclinic.services.PetTypeService;
import com.springframework.petclinic.services.SpecialityService;
import com.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Declare as component to create a spring bean.
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    //Autowired not needed.
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        // Constructor injection.
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Specialities

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        // Pet Types

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        // Owners and Pets

        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Smith");
        owner1.setAddress("123 Test");
        owner1.setCity("Athens");
        owner1.setTelephone("123123123");
        ownerService.save(owner1);

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.now());
        pet1.setName("Rosco");
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kyle");
        owner2.setLastName("Weebo");
        owner2.setAddress("789 Test");
        owner2.setCity("Athens");
        owner2.setTelephone("789789789");
        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("Just Cat");
        owner2.getPets().add(pet2);

        System.out.println("Loaded owners...");

        // Vets

        Vet vet1 = new Vet();
        vet1.setFirstName("Davie");
        vet1.setLastName("Man");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Davie2");
        vet2.setLastName("Man2");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }

}
