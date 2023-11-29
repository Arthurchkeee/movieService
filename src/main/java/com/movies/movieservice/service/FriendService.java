package com.movies.movieservice.service;

import com.movies.movieservice.model.FriendRequest;
import com.movies.movieservice.model.User;

import java.util.List;
import java.util.Set;

public interface FriendService {
    void sendFriendRequest(User recipient);
    Set<User> friendList();
    void acceptFriendRequest(FriendRequest friendRequest);
    List<FriendRequest> getUserFriendRequests();
    void rejectFriendRequest(FriendRequest friendRequest);
}
