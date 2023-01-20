package com.tweetero.api.model;

import com.tweetero.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_data")
public class User {

    public User(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;
}
