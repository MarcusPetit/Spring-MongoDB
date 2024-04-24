package com.example.mongodb.mongodb.entitides;

import com.example.mongodb.mongodb.dto.AuthorDTO;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Post {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}