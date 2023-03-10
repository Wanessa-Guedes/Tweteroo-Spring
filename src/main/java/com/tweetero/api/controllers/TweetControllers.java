package com.tweetero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.middlewares.ErrorAbstract;
import com.tweetero.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
@CrossOrigin(origins = "*")
public class TweetControllers extends ErrorAbstract {

    @Autowired
    TweetService service;

    @PostMapping
    public ResponseEntity<Object> PostTweet(@Valid @RequestBody TweetDTO req) throws Exception {
        if (req.username() == null || req.tweet() == null) {
            throw new Exception("Confira os dados! Estão faltando");
        }
        service.PostTweetService(req);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TweetDTO>> FindTweetsWithPagination(
            @RequestParam(defaultValue = "0", required = false) int page) {
        List<TweetDTO> pageOfTweets = service.FIlteredTweets(page);
        return ResponseEntity.ok().body(pageOfTweets);

    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TweetDTO>> FindTweetsByUser(@PathVariable(value = "username") String username) {
        List<TweetDTO> userTweets = service.GetTweetsByUserName(username);
        return ResponseEntity.ok().body(userTweets);
    }
}
