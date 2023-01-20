package com.tweetero.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.SignUpRepository;

@Service
public class SignUpService {

    @Autowired
    private SignUpRepository repository;

    public User signUp(UserDTO data) {
        System.out.println("ENTREIIIIIIII");
        System.out.println(new User(data));
        return repository.save(new User(data));
    }

}
