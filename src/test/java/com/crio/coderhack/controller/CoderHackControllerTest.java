package com.crio.coderhack.controller;

// public class CoderHackControllerTest {
    
// }

import com.crio.coderhack.entity.User;
import com.crio.coderhack.service.CoderHackService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

@WebMvcTest(CoderHackController.class)
public class CoderHackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoderHackService coderHackService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllUserTest() throws Exception {
        User user1 = new User("1", "User1", 10, Arrays.asList("badge1", "badge2"));
        User user2 = new User("2", "User2", 20, Arrays.asList("badge3", "badge4"));
        List<User> userList = Arrays.asList(user1, user2);

        given(coderHackService.findAllUsers()).willReturn(userList);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userList)));
    }

    @Test
    public void getByUserIdTest() throws Exception {
        User user = new User("1", "Test User", 10, Arrays.asList("badge1"));
        given(coderHackService.findByUserId("1")).willReturn(user);

        mockMvc.perform(get("/users/{userId}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(user)));
    }

    // @Test
    // public void postRequestTest() throws Exception {
    //     User user = new User("1", "New User", 10, Arrays.asList("badge1"));
    //     given(coderHackService.registerUser(Mockito.any(User.class))).willReturn(user);

    //     mockMvc.perform(post("/users")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(user)))
    //             .andExpect(status().isOk())
    //             .andExpect(content().json(objectMapper.writeValueAsString(user)));
    // }

    // Similarly, you can add tests for putById and deleteById
}