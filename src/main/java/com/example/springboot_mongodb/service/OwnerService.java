package com.example.springboot_mongodb.service;

import com.example.springboot_mongodb.domain.Owner;
import com.example.springboot_mongodb.domain.Pet;
import com.example.springboot_mongodb.repository.OwnerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerMongoRepository ownerMongoRepository;

    @Autowired
    public OwnerService(OwnerMongoRepository ownerMongoRepository) {
        this.ownerMongoRepository = ownerMongoRepository;
    }

    public List<Owner> getAllOwner() {
        return ownerMongoRepository.findAll();
    }

    @Cacheable("owners")
    public List<Owner> getAllOwnerCaching() {
        return ownerMongoRepository.findAll();
    }

    public Owner getOwnerById(String id) throws Exception {
        Optional<Owner> owner = ownerMongoRepository.findById(id);
        if (!owner.isPresent()) {
            throw new Exception("");
        }
        return owner.get();
    }

    public void saveOrUpdateOwner(Owner owner) {
        ownerMongoRepository.save(owner);
    }

    public Owner addPetToOwner(String id, Pet pet) throws Exception {
        Owner owner = getOwnerById(id);
        List<Pet> pets = owner.getPets();
        pets.add(pet);
        owner.setPets(pets);
        ownerMongoRepository.save(owner);
        return owner;
    }

    public Owner deleteOwnerById(String id) throws Exception {
        Owner owner = getOwnerById(id);
        ownerMongoRepository.deleteById(id);
        return owner;
    }

}
