package com.tweetero.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.middlewares.ErrorAbstract;
import com.tweetero.api.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
@CrossOrigin(origins = "*")
public class SignUpController extends ErrorAbstract {

    @Autowired
    SignUpService service;

    @PostMapping
    public ResponseEntity<Object> Sign(@Valid @RequestBody UserDTO req) throws Exception {
        if (req.username() == null || req.avatar() == null) {
            throw new Exception("Confira os dados! Estão faltando");
        }
        service.signUp(req);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
