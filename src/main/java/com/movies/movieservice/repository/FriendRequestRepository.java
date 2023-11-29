package com.movies.movieservice.repository;


import com.movies.movieservice.model.FriendRequest;
import com.movies.movieservice.model.FriendRequestStatus;
import com.movies.movieservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;
import java.util.Optional;

public interface FriendRequestRepository extends MongoRepository<FriendRequest, ObjectId> {
    @Query("{$and: [{$or:[{requester:?0},{recipient: ?1}]},{status: ?2}]}")
    List<FriendRequest> findFriendRequestsByRequesterOrRecipientAndStatus(ObjectId requester, ObjectId recipient, ObjectId friendRequestStatus);

    List<FriendRequest> findFriendRequestsByRecipientAndStatus(User recipient,FriendRequestStatus friendRequestStatus);

}
