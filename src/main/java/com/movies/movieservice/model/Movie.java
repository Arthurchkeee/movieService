package com.movies.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releasedDate;
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
    private Long budget;
    private Long USAFees;
    private Long fees;
    private String filePath;
}
