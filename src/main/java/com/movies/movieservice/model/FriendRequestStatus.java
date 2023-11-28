package com.movies.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document("friendRequestStatus")
public class FriendRequestStatus {
    @MongoId
    private ObjectId id;
    private EFriendRequestStatus name;

    public FriendRequestStatus(EFriendRequestStatus name) {
        this.name = name;
    }
}
