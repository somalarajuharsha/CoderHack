package com.crio.coderhack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crio.coderhack.entity.User;


@Repository
public interface CoderHackRepository extends MongoRepository<User,String>{
}
