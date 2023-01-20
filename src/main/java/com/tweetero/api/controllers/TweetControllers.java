package com.tweetero.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetControllers {

    @Autowired
    TweetService service;

    @PostMapping
    public ResponseEntity<Object> tweet(@RequestBody TweetDTO req) {
        service.tweet(req);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
