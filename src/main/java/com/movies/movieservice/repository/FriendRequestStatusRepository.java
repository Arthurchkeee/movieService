package com.movies.movieservice.repository;

import com.movies.movieservice.model.EFriendRequestStatus;
import com.movies.movieservice.model.FriendRequestStatus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendRequestStatusRepository extends MongoRepository<FriendRequestStatus, ObjectId> {
    FriendRequestStatus findByName(EFriendRequestStatus eFriendRequestStatus);
}
