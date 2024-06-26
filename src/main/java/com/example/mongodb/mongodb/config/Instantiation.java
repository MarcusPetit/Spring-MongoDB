package com.example.mongodb.mongodb.config;

import com.example.mongodb.mongodb.dto.AuthorDTO;
import com.example.mongodb.mongodb.dto.CommentsDTO;
import com.example.mongodb.mongodb.entitides.Post;
import com.example.mongodb.mongodb.entitides.User;
import com.example.mongodb.mongodb.repository.PostRepository;
import com.example.mongodb.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços", new AuthorDTO(maria) );
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje.", new AuthorDTO(maria));

        CommentsDTO c1 = new CommentsDTO("Boa viagem mano!" , sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentsDTO c2 = new CommentsDTO("Aproveite!" , sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentsDTO c3 = new CommentsDTO("Tenha um otimo dia!" , sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getCommentsDTOS().addAll(Arrays.asList(c1,c2));
        post2.getCommentsDTOS().add(c3);


        postRepository.saveAll((Arrays.asList(post1,post2)));

        maria.getPost().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
