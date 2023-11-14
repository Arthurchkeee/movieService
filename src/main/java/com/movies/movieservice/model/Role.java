package com.movies.movieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@ToString
@Document("roles")
public class Role {
    @Id
    private String id;
    private ERole name;
}
