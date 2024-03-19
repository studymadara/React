package com.react.java.dao.user;

import com.react.java.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUser(String userName);

    void saveUser(User user);
}
