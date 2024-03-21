package com.crio.coderhack.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.coderhack.entity.User;
import com.crio.coderhack.service.CoderHackService;
import com.crio.coderhack.service.CoderHackServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CoderHackController {

    @Autowired
    private CoderHackService coderHackService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> resp=coderHackService.findAllUsers();
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getByUserId(@PathVariable(value = "userId") String userId) {
        User response=coderHackService.findByUserId(userId);
        if(response==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/users")
    public ResponseEntity<User> postRequest(@RequestBody User user) {
        if(coderHackService.validate(user)==false){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User response=coderHackService.registerUser(user);
        if(response==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok().body(response);
    }
    
    @PutMapping("users/{userId}")
    public ResponseEntity<User> putById(@PathVariable(value = "userId") String id, @RequestBody User user) {
        if(coderHackService.validateScore(user.getScore())==false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User response=coderHackService.updateUser(id, user.getScore());
        if(response==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "userId") String id) {
        User response=coderHackService.findByUserId(id);
        if(response==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coderHackService.deregisterUser(id);
        return ResponseEntity.ok().body("User Deleted Successfully");
    }
    
    
}
