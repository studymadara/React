package com.react.java.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUser(username).map(t -> new User(t.getUserName()
                        , new BCryptPasswordEncoder().encode(t.getUserPass())
                        , Collections.singleton(new SimpleGrantedAuthority(t.getUserRole()))))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    public void saveUserService(com.react.java.model.User user) {
        userRepository.saveUser(user);
    }

}
