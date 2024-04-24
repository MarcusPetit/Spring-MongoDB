package com.example.mongodb.mongodb.repository;

import com.example.mongodb.mongodb.entitides.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
