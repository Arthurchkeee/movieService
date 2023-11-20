package com.movies.movieservice.repository;

import com.movies.movieservice.model.Country;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CountryRepository extends MongoRepository<Country, ObjectId> {
    List<Country> findAll();

    Country findByName(String name);
}
