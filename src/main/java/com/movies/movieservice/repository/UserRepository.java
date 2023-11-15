package com.movies.movieservice.repository;

import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByUsername(String username);

    User findByUsernameOrEmail(String username, String username1);

    boolean existsByUsername(String username);
}
