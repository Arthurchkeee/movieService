package com.movies.movieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@Document("users")
public class User {
    @Id
    private @MongoId ObjectId id;
    private String username;
    private String password;
    private String email;
    @DBRef
    private Set<Role> authorities;
}
