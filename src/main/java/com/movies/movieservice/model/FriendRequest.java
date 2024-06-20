package com.movies.movieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@NoArgsConstructor
@Data
@Document("friendRequests")
public class FriendRequest {
    @MongoId
    private ObjectId id;
    @DBRef
    private User requester;
    @DBRef
    private User recipient;
    @DBRef
    private FriendRequestStatus status;

    public FriendRequest(User requester, User recipient, FriendRequestStatus status) {
        this.requester = requester;
        this.recipient = recipient;
        this.status = status;
    }
}
