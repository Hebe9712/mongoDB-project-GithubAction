package com.example.springboot_mongodb.controller;

import com.example.springboot_mongodb.domain.Owner;
import com.example.springboot_mongodb.domain.Pet;
import com.example.springboot_mongodb.repository.OwnerMongoRepository;
import com.example.springboot_mongodb.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "/owners")
    public ResponseEntity<List<Owner>> getAllOwner() {
        List<Owner> owners = ownerService.getAllOwner();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping(value = "/owners/caching")
    public ResponseEntity<List<Owner>> getAllOwnerCaching() {
        List<Owner> owners = ownerService.getAllOwnerCaching();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping(value = "/owner/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable String id) {
        try {
            Owner owner = ownerService.getOwnerById(id);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/owner")
    public ResponseEntity<Owner> saveOrUpdateOwner(@RequestBody Owner owner) {
        ownerService.saveOrUpdateOwner(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping(value = "/owner/{id}/pet")
    public ResponseEntity<Owner> addPetToOwner(@PathVariable String id, @RequestBody Pet pet) {
        try {
            Owner owner = ownerService.addPetToOwner(id, pet);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/owner/{id}")
    public ResponseEntity<Owner> deleteOwnerById(@PathVariable String id) {
        try {
            Owner owner = ownerService.deleteOwnerById(id);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
