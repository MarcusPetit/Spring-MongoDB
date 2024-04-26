package com.example.mongodb.mongodb.controllers;

import com.example.mongodb.mongodb.controllers.util.URL;
import com.example.mongodb.mongodb.entitides.Post;
import com.example.mongodb.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.awt.SystemColor.text;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
