package com.movies.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Movie")
public class Movie {
    @Id
    private String id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releasedDate;
    private String year;
    private Set<String> director = new HashSet<>();
    private Set<String> country = new HashSet<>();
    private Set<String> writer = new HashSet<>();
    private Set<String> genre = new HashSet<>();
    private Set<String> producer = new HashSet<>();
    private Set<String> operator = new HashSet<>();
    private Set<String> composer = new HashSet<>();
    private Set<String> artist = new HashSet<>();
    private Set<String> editor = new HashSet<>();
    private Long budget;
    private Long USAFees;
    private Long fees;
    private String filePath;
}
