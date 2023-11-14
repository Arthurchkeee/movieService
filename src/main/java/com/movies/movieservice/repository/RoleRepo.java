package com.movies.movieservice.repository;

import com.movies.movieservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByName(String name);
}
