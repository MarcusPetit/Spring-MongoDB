package com.example.mongodb.mongodb.services;

import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.entitides.Post;
import com.example.mongodb.mongodb.entitides.User;
import com.example.mongodb.mongodb.repository.PostRepository;
import com.example.mongodb.mongodb.repository.UserRepository;
import com.example.mongodb.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id ){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));

    }

    public List<Post> findByTitle(String text) {
        return repository.resultTitle(text);
    }


    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.allSearch(text, minDate, maxDate);
    }




}
