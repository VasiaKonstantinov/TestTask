package com.example.testtask.service;

import com.example.testtask.models.Person;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.request.RegisterRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonServiceTest {
@Autowired
private PersonService personService;

@MockBean
private PersonRepository personRepository;

    @Test
    void register() {
        RegisterRequest request = new RegisterRequest();
        Person person = new Person();
        boolean isPersonCreated = personService.register(request);
        Assert.assertTrue(isPersonCreated);
        Mockito.verify(personRepository, Mockito.times(1)).save(person);
    }
}