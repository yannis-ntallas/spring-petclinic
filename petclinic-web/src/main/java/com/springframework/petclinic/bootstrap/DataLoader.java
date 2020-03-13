package com.springframework.petclinic.bootstrap;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.OwnerService;
import com.springframework.petclinic.services.PetTypeService;
import com.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Declare as component to create a spring bean.
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //Autowired not needed.
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        // Constructor injection.
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        // Create some test owners.
        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kyle");
        owner2.setLastName("Weebo");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        //Create some test Vets.
        Vet vet1 = new Vet();
        vet1.setFirstName("Davie");
        vet1.setLastName("Man");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Davie2");
        vet2.setLastName("Man2");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }

}
