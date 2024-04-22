package com.example.mongodb.mongodb.repository;

import com.example.mongodb.mongodb.entitides.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, Long> {
}
