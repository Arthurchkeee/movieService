package com.movies.movieservice.repository;

import com.movies.movieservice.model.ERole;
import com.movies.movieservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional<Role> findByName(ERole name);
}
