package com.crio.coderhack.service;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crio.coderhack.entity.User;
import com.crio.coderhack.repository.CoderHackRepository;

@SpringBootTest
public class CoderHackServiceImplTest {

    @MockBean
    private CoderHackRepository coderHackRepository;

    @Autowired
    private CoderHackService coderHackService;

    @Test
    public void getTestUserById(){
        User user=new User("1", "check", 0, null);
        Mockito.when(coderHackRepository.findById("1")).thenReturn(Optional.of(user));
        
    }
}
