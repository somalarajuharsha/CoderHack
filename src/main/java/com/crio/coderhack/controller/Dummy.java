package com.crio.coderhack.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Dummy {
    @GetMapping("check")
    public String getMethodName() {
        return "Working Good!";
    }
    
}
