package com.movies.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String title;
    private String description;
    private String releasedDate;
    private String year;
    private List<String> director;
    private List<String> country;
    private List<String> writer;
    private List<String> genre;
    private List<String> producer;
    private List<String> operator;
    private List<String> composer;
    private List<String> artist;
    private List<String> editor;
    private int budget;
    private int USAFees;
    private int fees;
    private String filePath;
}
