package com.movies.movieservice.service.impl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.repository.CountryRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext
class CountyServiceImplTest {
    @Autowired
    CountyServiceImpl countyService;
    @Autowired
    CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        countryRepository.saveAll(new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))));
    }

    @AfterEach
    void tearDown() {
        countryRepository.deleteAll();
    }

    @Test
    void findAll() {
        assertThat(countyService.findAll().size()).isEqualTo(3);
    }
}