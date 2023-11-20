package com.movies.movieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@ToString
@Document("roles")
public class Role {
    @MongoId
    private ObjectId id;
    private ERole name;
}
