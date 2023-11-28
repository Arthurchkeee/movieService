package com.movies.movieservice.repository;


import com.movies.movieservice.model.FriendRequest;
import com.movies.movieservice.model.FriendRequestStatus;
import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface FriendRequestRepository extends MongoRepository<FriendRequest, ObjectId> {
    List<FriendRequest> findFriendRequestsByRequesterOrRecipientAndStatus(User requester, User recipient, FriendRequestStatus friendRequestStatus);

}
