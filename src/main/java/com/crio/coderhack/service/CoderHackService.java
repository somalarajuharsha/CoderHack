package com.crio.coderhack.service;

import java.util.List;

import com.crio.coderhack.entity.User;

public interface CoderHackService {

    List<User> findAllUsers();

    User findByUserId(String userId);

    boolean validate(User user);

    User registerUser(User user);

    boolean validateScore(Integer score);

    User updateUser(String id, Integer score);

    void deregisterUser(String id);
    
}
