package com.example.webapp.controller;

import com.example.webapp.entities.EMAIL;
import com.example.webapp.entities.users;
import com.example.webapp.repository.EMAILREPOSITORY;
import com.example.webapp.repository.USERREPOSITORY;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.reflect.Array.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CONTROLLER.class)

class CONTROLLERunitTest {
    @MockBean
    USERREPOSITORY ur;
    @MockBean
    EMAILREPOSITORY er;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper om;

    @Test
    void user_creates_or_not() throws Exception {

        users us = new users(1, "sai", "bhowmik", "123456", "a@gmail.com");


        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(us)))
                .andExpect(status().isOk()).andDo(print());


    }

    @Test
    void email_creates_or_not() throws Exception {

        EMAIL el = new EMAIL();
        el.setEmail_id(10);
        el.setEmail_to("b@gmail.com");
        el.setEmail_from("a@gmail.com");
        el.setBody("sd");
        el.setSubject("afsd");
        el.setUsers(new users(1, "sai", "bhowmik", "123456", "a@gmail.com"));
        mockMvc.perform((post("/email")).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(el)))
                .andExpect(status().isOk()).andDo(print());

    }

    @Test
    void should_return_all_users() throws Exception {
        List<users> l = new ArrayList<>();
        l.add(new users(1, "sai", "bhowmik", "123456", "a@gmail.com"));
        l.add(new users(1, "sai", "bhowmik", "123456", "a@gmail.com"));
        when(ur.findAll()).thenReturn(l);
        mockMvc.perform(MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$[0].firstname").
                        value("sai"));
    }

    @Test
    void should_return_mentioned_user() throws Exception {
        users us = new users(1, "sai", "bhowmik", "123456", "a@gmail.com");
        when(ur.findById(1)).thenReturn(Optional.of(us));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.firstname").
                        value("sai"));
    }

    @Test
    void count_of_emails() throws Exception {
        List<EMAIL> l = new ArrayList<>();
        EMAIL el = new EMAIL();
        el.setEmail_id(10);
        el.setEmail_to("b@gmail.com");
        el.setEmail_from("a@gmail.com");
        el.setBody("sd");
        el.setSubject("afsd");
        el.setUsers(new users(1, "sai", "bhowmik", "123456", "a@gmail.com"));
        l.add(el);
        EMAIL el2=new EMAIL();
        el2.setEmail_id(11);
        el2.setEmail_to("b@gmail.com");
        el2.setEmail_from("a@gmail.com");
        el2.setBody("sd");
        el2.setSubject("afsd");
        el2.setUsers(new users(1, "sai", "bhowmik", "123456", "a@gmail.com"));
        l.add(el2);

        when(er.countByUsersId(1)).thenReturn(2);
        mockMvc.perform(MockMvcRequestBuilders.get("/emails-count/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());

    }
}