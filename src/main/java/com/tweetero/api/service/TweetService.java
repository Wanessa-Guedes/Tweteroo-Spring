package com.tweetero.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.middlewares.ErrorAbstract;
import com.tweetero.api.model.Tweet;
import com.tweetero.api.model.User;
import com.tweetero.api.repository.SignUpRepository;
import com.tweetero.api.repository.TweetRepository;

import jakarta.validation.ValidationException;

@Service
public class TweetService extends ErrorAbstract {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    public Tweet PostTweetService(TweetDTO data) {
        User userData = signUpRepository.findByUsername(data.username());
        if (userData == null) {
            throw new ValidationException("Esse usuário não está cadastrado!");
        }
        String avatar = userData.getAvatar();
        Tweet obj = new Tweet(data);
        obj.setAvatar(avatar);
        return tweetRepository.save(obj);
    }

    public List<TweetDTO> FIlteredTweets(int page) {
        Page<Tweet> filterTweets = tweetRepository.findAll(PageRequest.of(page, 5).withSort(Direction.DESC, "id"));
        List<TweetDTO> filterTweetsDTO = new ArrayList<>();
        filterTweets.getContent()
                .forEach(obj -> filterTweetsDTO.add(new TweetDTO(obj.getUsername(), obj.getAvatar(), obj.getTweet())));
        return filterTweetsDTO;
    }

    public List<TweetDTO> GetTweetsByUserName(String data) {
        List<Tweet> tweeters = tweetRepository.findByUsername(data);
        if (tweeters.isEmpty()) {
            throw new ValidationException("Esse usuário não está cadastrado!");
        }
        List<TweetDTO> tweetersDTO = new ArrayList<>();
        tweeters.forEach(obj -> tweetersDTO.add(new TweetDTO(obj.getUsername(), obj.getAvatar(), obj.getTweet())));
        return tweetersDTO;
    }

}
