package com.react.java.dao.user;

import com.react.java.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private UserDaoDynamo userDaoDynamo;

    public UserRepository(UserDaoDynamo userDaoDynamo) {
        this.userDaoDynamo = userDaoDynamo;
    }

    public Optional<User> getUser(String userName) {
        return userDaoDynamo.getUser(userName);
    }

    public void saveUser(User user) {
        userDaoDynamo.saveUser(user);
    }
}
