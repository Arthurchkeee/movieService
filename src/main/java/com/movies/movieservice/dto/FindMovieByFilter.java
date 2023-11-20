package com.movies.movieservice.dto;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindMovieByFilter {
    private Genre genreFilter=new Genre();
    private Country countryFilter=new Country();
}
