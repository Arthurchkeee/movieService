package com.movies.movieservice.repository;

import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByUsername(String username);

    User findByUsernameOrEmail(String username, String username1);

    boolean existsByUsername(String username);
    @Query("{'username':{$regex: ?0}}")
    List<User> findUsersByUsernameSubstring(String usernameSubstring);
}
