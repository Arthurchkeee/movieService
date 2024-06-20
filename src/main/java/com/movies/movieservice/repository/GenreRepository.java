package com.movies.movieservice.repository;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre, ObjectId> {
    List<Genre> findAll();

    Genre findByName(String name);
}
