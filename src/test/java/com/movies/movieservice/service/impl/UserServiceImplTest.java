package com.movies.movieservice.service.impl;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.model.*;
import com.movies.movieservice.repository.*;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.UserService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@DirtiesContext
class UserServiceImplTest {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    GenreRepository genreRepository;
    @BeforeEach
    void setUp() {
        roleRepository.saveAll(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR)));
        User user=new User("bebra",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void findUserByUsername() {
        assertTrue(userService.findUserByUsername("bebra").isPresent());
    }

    @Test
    void save() {
        User user=new User("test1","test","test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        userService.save(user);
        assertTrue(userRepository.findById(user.getId()).isPresent());
    }

    @Test
    void findAllUsers() {
        assertThat(userService.findAllUsers().size()).isEqualTo(1);
    }

    @Test
    void addMovieToWatchlist() throws ParseException {
        countryRepository.saveAll(new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))));
        genreRepository.saveAll(new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))));
        Movie firstMovie = new Movie( null, "test", "test", new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"), "2023-11-16", new HashSet<>(Arrays.asList("Shibe", " Pupper")), new HashSet<>(Arrays.asList( new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))),  new HashSet<>(Arrays.asList("Shibe", "Pupper")), new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))),  new HashSet<>(Arrays.asList("Shibe", "Pupper")),  new HashSet<>(Arrays.asList("Shibe", "Pupper")), new HashSet<>(Arrays.asList("Shibe", "Pupper")),  new HashSet<>(Arrays.asList("Shibe", "Pupper")), new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L,  null);
        movieRepository.save(firstMovie);
        authService.authenticateUser(new SignInDto("bebra","test"));
        userService.addMovieToWatchlist(firstMovie);
        Set<Movie> movies=userRepository.findUserByUsername("bebra").get().getWatchlist();
        assertThat(movies.size()).isEqualTo(1);
        assertTrue(movies.contains(firstMovie));
    }

    @Test
    void findUsersByUsernameSubstring() {
        User user=new User("bebra123",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        User user1=new User("123",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        userRepository.saveAll(Arrays.asList(user,user1));
        assertThat(userService.findUsersByUsernameSubstring("bebra").size()).isEqualTo(2);
        assertThat(userService.findUsersByUsernameSubstring("123").size()).isEqualTo(2);
    }
}