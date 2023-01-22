package com.tweetero.api.service;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.middlewares.ErrorAbstract;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.SignUpRepository;

@Service
public class SignUpService extends ErrorAbstract {

    @Autowired
    private SignUpRepository repository;

    public User signUp(UserDTO data) throws AccountException {
        User isUser = repository.findByUsername(data.username());
        if (isUser != null) {
            throw new AccountException("Esse usuário já está cadastrado!");
        }
        return repository.save(new User(data));
    }

}
