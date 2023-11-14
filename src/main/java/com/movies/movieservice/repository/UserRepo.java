package com.movies.movieservice.repository;

import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findUserByUsername(String username);
}
