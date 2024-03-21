package com.crio.coderhack.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@Document(collection = "coderhack")
 @NoArgsConstructor
 @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String id;
    private String name;
    private Integer score;
    private List<String> badge;
//    public String getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public Integer getScore() {
//        return score;
//    }
//    public List<String> getBadge() {
//        return badge;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setScore(Integer score) {
//        this.score = score;
//    }
//    public void setBadge(List<String> badge) {
//        this.badge = badge;
//    }
//
//    public User(){
//        super();
//        id=null;
//        name=null;
//        score=0;
//        badge=null;
//    }
//    public User(String id,String name,Integer score,List<String> badge){
//        super();
//        this.id=id;
//        this.name=name;
//        this.score=score;
//        this.badge=badge;
//    }
//

}
