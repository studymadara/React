package com.react.java.dao.user;

import com.react.java.model.User;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

public class UserDaoDynamo implements UserDao {

    static final String TABLE_NAME = "User";
    private final DynamoDbTable<User> table;

    public UserDaoDynamo(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.table = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(User.class));
    }

    @Override
    public Optional<User> getUser(String userName) {
        return Optional.ofNullable(table.getItem(Key.builder().partitionValue(userName).build()));
    }

    @Override
    public void saveUser(User user) {
        table.putItem(user);
    }
}
