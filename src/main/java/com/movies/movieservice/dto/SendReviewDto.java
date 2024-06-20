package com.movies.movieservice.dto;

import com.movies.movieservice.model.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendReviewDto {
    private String title;
    private String textOfReview;
    private Integer mark;
    private Movie movie;
}
