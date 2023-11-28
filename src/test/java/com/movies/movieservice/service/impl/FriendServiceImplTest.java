package com.movies.movieservice.service.impl;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.model.*;
import com.movies.movieservice.repository.FriendRequestRepository;
import com.movies.movieservice.repository.FriendRequestStatusRepository;
import com.movies.movieservice.repository.RoleRepository;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.FriendService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.HashSet;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
class FriendServiceImplTest {
    @Autowired
    FriendRequestStatusRepository friendRequestStatusRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FriendService friendService;
    @Autowired
    FriendRequestRepository friendRequestRepository;
    @Autowired
    AuthService authService;
    @BeforeEach
    void setUp() {
        friendRequestStatusRepository.saveAll(Arrays.asList(new FriendRequestStatus(new ObjectId("6565b0467836499be6892c56"),EFriendRequestStatus.REQUESTED),new FriendRequestStatus(new ObjectId("6565b0467836499be6892c57"),EFriendRequestStatus.ACCEPTED),new FriendRequestStatus(new ObjectId("6565b0467836499be6892c58"),EFriendRequestStatus.REJECTED)));
        roleRepository.saveAll(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR)));
        User user=new User("bebra",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        User user1=new User("bebra1234",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        userRepository.saveAll(Arrays.asList(user,user1));
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        friendRequestStatusRepository.deleteAll();
        friendRequestRepository.deleteAll();
    }

    @Test
    void sendFriendRequest() {
        authService.authenticateUser(new SignInDto("bebra","test"));
        friendService.sendFriendRequest(userRepository.findUserByUsername("bebra1234").get());
        assertThat(friendRequestRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void friendList() {
        authService.authenticateUser(new SignInDto("bebra","test"));
        friendService.sendFriendRequest(userRepository.findUserByUsername("bebra1234").get());
        friendService.acceptFriendRequest(friendRequestRepository.findAll().get(0));
        assertThat(friendService.friendList().size()).isEqualTo(1);
        assertTrue(friendService.friendList().contains(userRepository.findUserByUsername("bebra1234").get()));
        User user1=new User("bebra12345",new BCryptPasswordEncoder().encode("test"),"test@gmail.com",new HashSet<>(Arrays.asList(new Role(new ObjectId("65521f00636e7db7f10ca444"), ERole.ROLE_ADMIN),new Role(new ObjectId("65521f00636e7db7f10ca445"),ERole.ROLE_USER),new Role(new ObjectId("65521f00636e7db7f10ca446"),ERole.ROLE_MODERATOR))));
        userRepository.save(user1);
        friendRequestRepository.save(new FriendRequest(userRepository.findUserByUsername("bebra12345").get(),userRepository.findUserByUsername("bebra").get(),friendRequestStatusRepository.findByName(EFriendRequestStatus.ACCEPTED)));
        assertThat(friendService.friendList().size()).isEqualTo(2);
    }

    @Test
    void acceptFriendRequest() {
        friendRequestRepository.save(new FriendRequest(userRepository.findUserByUsername("bebra1234").get(),userRepository.findUserByUsername("bebra").get(),friendRequestStatusRepository.findByName(EFriendRequestStatus.REQUESTED)));
        authService.authenticateUser(new SignInDto("bebra","test"));
        friendService.acceptFriendRequest(friendRequestRepository.findAll().get(0));
        assertThat(friendRequestRepository.findAll().get(0).getStatus()).isEqualTo(friendRequestStatusRepository.findByName(EFriendRequestStatus.ACCEPTED));
    }
}