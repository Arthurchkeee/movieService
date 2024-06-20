package com.movies.movieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@Data
@Document("reviews")
public class Review {
    @MongoId
    private ObjectId id;
    private String title;
    private String textOfReview;
    private Integer mark;
    @DBRef
    private Movie movie;
    @DBRef
    private User user;
}
