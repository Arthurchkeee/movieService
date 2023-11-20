package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.repository.CountryRepository;
import com.movies.movieservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountyServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
