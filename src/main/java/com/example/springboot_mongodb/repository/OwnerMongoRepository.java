package com.example.springboot_mongodb.repository;

import com.example.springboot_mongodb.domain.Owner;
import com.example.springboot_mongodb.domain.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerMongoRepository extends MongoRepository<Owner, String> {
    //List<Pet>
}
