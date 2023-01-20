package com.tweetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
