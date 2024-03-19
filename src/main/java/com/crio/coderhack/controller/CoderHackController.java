package com.crio.coderhack.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.coderhack.entity.User;
import com.crio.coderhack.service.CoderHackService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity getByUserId(@RequestParam String param) {
        return null;
    }
    

    @PostMapping("/users")
    public ResponseEntity postRequest(@RequestBody User user) {
        return null;
    }
    
    @PutMapping("users/{useId}")
    public ResponseEntity putById(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return null;
    }
    
    @DeleteMapping("users/{useId}")
    public ResponseEntity deleteById(@PathVariable String id) {
        return null;
    }
    
    
}
