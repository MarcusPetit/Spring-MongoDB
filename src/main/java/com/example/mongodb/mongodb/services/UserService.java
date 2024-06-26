package com.example.mongodb.mongodb.services;

import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.entitides.User;
import com.example.mongodb.mongodb.repository.UserRepository;
import com.example.mongodb.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id ){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));

    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public  void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newObj = repository.findById(obj.getId());
        User user = newObj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));

        updateData(obj, user);
        return repository.save(user);

    }

    public void updateData(User obj, User user){
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());


    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }



}
