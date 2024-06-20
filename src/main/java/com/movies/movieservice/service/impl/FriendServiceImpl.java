package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.EFriendRequestStatus;
import com.movies.movieservice.model.FriendRequest;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.FriendRequestRepository;
import com.movies.movieservice.repository.FriendRequestStatusRepository;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendRequestStatusRepository friendRequestStatusRepository;
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void sendFriendRequest(User recipient) {
        Optional<User> currentUser = userRepository.findUserByUsername(AuthService.getAuthenticationUserName());
        if (currentUser.isPresent()) {
            FriendRequest friendRequest = new FriendRequest(currentUser.get(), recipient, friendRequestStatusRepository.findByName(EFriendRequestStatus.REQUESTED));
            friendRequestRepository.save(friendRequest);
        }
    }

    @Override
    public Set<User> friendList() {
        Set<User> friendship = new HashSet<>();
        Optional<User> currentUser = userRepository.findUserByUsername(
                AuthService.getAuthenticationUserName());
        if (currentUser.isPresent()) {
            List<FriendRequest> requests = friendRequestRepository.findFriendRequestsByRequesterOrRecipientAndStatus(currentUser.get().getId(), currentUser.get().getId(), friendRequestStatusRepository.findByName(EFriendRequestStatus.ACCEPTED).getId());
            requests.forEach(friendRequest -> {
                if (currentUser.get().equals(friendRequest.getRequester())) {
                    friendship.add(friendRequest.getRecipient());
                } else {
                    friendship.add(friendRequest.getRequester());
                }
            });
        } else
            throw new RuntimeException("This user doesn't exist");
        return friendship;
    }

    @Transactional
    @Override
    public void acceptFriendRequest(FriendRequest friendRequest) {
        friendRequest.setStatus(friendRequestStatusRepository.findByName(EFriendRequestStatus.ACCEPTED));
        friendRequestRepository.save(friendRequest);
    }

    @Override
    public List<FriendRequest> getUserFriendRequests() {
        if (userRepository.findUserByUsername(AuthService.getAuthenticationUserName()).isPresent()) {
            return friendRequestRepository.findFriendRequestsByRecipientAndStatus(userRepository.findUserByUsername(AuthService.getAuthenticationUserName()).get(), friendRequestStatusRepository.findByName(EFriendRequestStatus.REQUESTED));
        } else
            throw new RuntimeException("This user doesn't exist");

    }

    @Override
    @Transactional
    public void rejectFriendRequest(FriendRequest friendRequest) {
        friendRequest.setStatus(friendRequestStatusRepository.findByName(EFriendRequestStatus.REJECTED));
        friendRequestRepository.save(friendRequest);
    }

    @Override
    public List<FriendRequest> getOutputFriendRequest() {
        if (userRepository.findUserByUsername(AuthService.getAuthenticationUserName()).isPresent()) {
            return friendRequestRepository.findFriendRequestsByRequesterAndStatus(userRepository.findUserByUsername(AuthService.getAuthenticationUserName()).get(), friendRequestStatusRepository.findByName(EFriendRequestStatus.REQUESTED));
        } else
            throw new RuntimeException("This user doesn't exist");
    }
}
