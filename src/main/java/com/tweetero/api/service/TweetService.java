package com.tweetero.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.model.Tweet;
import com.tweetero.api.repository.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public Tweet tweet(TweetDTO data) {
        return repository.save(new Tweet(data));
    }

}
