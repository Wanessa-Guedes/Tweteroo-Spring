package com.tweetero.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.model.User;
import com.tweetero.api.service.SignUpService;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    SignUpService service;

    @PostMapping
    public ResponseEntity<UserDTO> sign(@RequestBody UserDTO req) {
        User userData = service.signUp(req);
        UserDTO userDataDto = new UserDTO(userData.getUsername(), userData.getAvatar());
        return ResponseEntity.ok().body(userDataDto);
    }
}
