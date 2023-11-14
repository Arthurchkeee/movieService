package com.movies.movieservice.repository;

import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findUserByUsername(String username);

    User findByUsernameOrEmail(String username, String username1);

    boolean existsByUsername(String username);
}
