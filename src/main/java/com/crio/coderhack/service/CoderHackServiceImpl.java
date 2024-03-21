package com.crio.coderhack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.crio.coderhack.entity.User;
import com.crio.coderhack.repository.CoderHackRepository;
import java.util.*;

@Service
public class CoderHackServiceImpl implements CoderHackService {

    @Autowired
    private CoderHackRepository coderHackRepository;

    public List<User> findAllUsers(){
        List<User> result=coderHackRepository.findAll();
        Collections.sort(result, (a,b)->b.getScore()-a.getScore());
        return result;
    }

    public User findByUserId(String userId){
        Optional<User> result=coderHackRepository.findById(userId);
        return result.orElse(null);
    }

    // public User registerUser(String userId, String userName){
    //     Optional<User> result=coderHackRepository.findById(userId);
    //     User found=result.orElse(null);
    //     if(found==null){
    //         return null;
    //     }
    //     User registerUser=new User(userId, userName, 0, null);
        // registerUser.setId(userId);
        // registerUser.setName(userName);
        // registerUser.setScore(0);
    //     coderHackRepository.insert(registerUser);
    //     return registerUser;
    // }

    public User registerUser(User user) {
        String userId=user.getId();
        String userName=user.getName();

        if(coderHackRepository.existsById(userId)){
            return null;
        }
        else{
            
            User respose=new User(userId, userName, 0, null);
            coderHackRepository.insert(respose);
            return respose;
        }

    }

    public User updateUser( String id, Integer score){
        Optional<User> result=coderHackRepository.findById(id);
        User userById=result.orElse(null);
        if(userById==null){
            return null;
        }
        // userById.setScore(score);
        // userById.getBadge().clear();
        List<String> badges=new ArrayList<>();
        if(score>=1&&score<=30){
            badges.add("Code Ninja");
        }else if(score>=31&&score<=60){
            badges.add("Code Ninja");
            badges.add("Code Champ");
        }else if(score>=61&&score<=100){
            badges.add("Code Ninja");
            badges.add("Code Champ");
            badges.add("Code Master");
        }

        User response=new User(userById.getId(), userById.getName(), score, badges);
        coderHackRepository.save(response);
        return response;
    }

    public boolean validate(User user){
        if(user.getId()!=null||user.getName()!=null){
            return true;
        }
        return false;
    }

    public boolean validateScore(Integer score){
        if(score>=0&&score<=100){
            return true;
        }
        return false;
    }

    public void deregisterUser(String id) {
       coderHackRepository.deleteById(id);
    }
}
