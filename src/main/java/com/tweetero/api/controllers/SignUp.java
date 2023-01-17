package com.tweetero.api.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;

@RestController
@RequestMapping("/sign-up")
public class SignUp {

    private HashMap<String, String> userInfo = new HashMap<>();

    @PostMapping
    public ResponseEntity<HashMap<String, String>> sign(@RequestBody UserDTO req) {
        userInfo.put("username", req.username());
        userInfo.put("avatar", req.avatar());
        System.out.println(userInfo);
        return ResponseEntity.ok().body(userInfo);
    }
}
