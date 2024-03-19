package com.crio.coderhack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.coderhack.entity.User;
import com.crio.coderhack.repository.CoderHackRepository;
import java.util.*;

@Service
public class CoderHackService {

    @Autowired
    private CoderHackRepository coderHackRepository;

    public List<User> findAllUsers(){
        List<User> result=coderHackRepository.findAll();
        return result;
    }
}
