package com.example.mongodb.mongodb.controllers;

import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.entitides.User;
import com.example.mongodb.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //Como vai receber varios Usuarios como retorno precisa ser uma <LISTA>
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //Por receber apenas um usuario não precisa usar uma <LISTA>
    @GetMapping("/{id}")
    //Para saber o id que vai ser procurado com o id do parametro
    //usamos o @PathVariable
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
