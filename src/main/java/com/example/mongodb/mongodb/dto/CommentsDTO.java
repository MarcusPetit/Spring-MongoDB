package com.example.mongodb.mongodb.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CommentsDTO {
    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentsDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
