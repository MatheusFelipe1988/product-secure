package com.system.security.service;

import com.system.security.domain.User;
import com.system.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UserRepository repository;
    @Override
    public User create(User user) {
        User existUser = repository.findByUsername(user.getUsername());

        if(existUser != null){
            throw new Error("User exist");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User createdUser = repository.save(user);

        return createdUser;
    }
}
