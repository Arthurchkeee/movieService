package com.movies.movieservice.repository;

import com.movies.movieservice.model.ERole;
import com.movies.movieservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
    Role findByName(ERole name);
}
