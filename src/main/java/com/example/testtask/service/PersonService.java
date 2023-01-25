package com.example.testtask.service;

import com.example.testtask.models.Person;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public boolean register(RegisterRequest request) {
        var user = Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .build();
        personRepository.save(user);
        return true;
    }
}

