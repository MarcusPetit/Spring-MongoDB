package com.example.mongodb.mongodb.dto;


import com.example.mongodb.mongodb.entitides.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }
    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
