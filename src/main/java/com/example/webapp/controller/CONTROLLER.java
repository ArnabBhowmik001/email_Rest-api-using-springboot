package com.example.webapp.controller;

import com.example.webapp.entities.EMAIL;
import com.example.webapp.entities.users;
import com.example.webapp.repository.EMAILREPOSITORY;
import com.example.webapp.repository.USERREPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CONTROLLER {
    @Autowired
    private USERREPOSITORY ur;
    @Autowired
    private EMAILREPOSITORY er;

    @PostMapping("/user")
    public users createuser(@RequestBody users us){
        ur.save(us);
        return us;

    }
    @PostMapping("/email")
    public EMAIL createemail(@RequestBody EMAIL el ){

    er.save(el);
    return el;

    }
    @GetMapping("/users")
    public List<users> getusers(){

        return ur.findAll();
    }

    @GetMapping("/user/{id}")
    public users getuser(@PathVariable("id") int id){

        return ur.findById(id).orElse(null);
    }
    @GetMapping("/emails-count/{id}")//emails count by user id
    public String countemails(@PathVariable("id") int id){

        return ("email count of user id "+id+" is:"+er.countByUsersId(id));
    }
    @GetMapping("/emails")
    public List<EMAIL> getemails(){

        return er.findAll();
    }
}
