package com.example.testtask.controller;

import com.example.testtask.models.Person;
import com.example.testtask.request.RegisterRequest;
import com.example.testtask.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService service;
    @Test
    public void out() throws Exception{

        Person alex = new Person(1L,"alex","alex",1);

        given(service.getById(alex.getId())).willReturn(alex);

        mvc.perform(get("http://localhost:8080/out/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(alex.getId().intValue())))
                .andExpect(jsonPath("$.firstName", is(alex.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(alex.getLastName())))
                .andExpect(jsonPath("$.age", is(alex.getAge())));
    }

//    @Test
//    void in() throws Exception{
//        RegisterRequest request = new RegisterRequest("alex", "alex", 1);
//
//        given(service.register(request)).willReturn(true);
//
//        mvc.perform(get("http://localhost:8080/in")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}