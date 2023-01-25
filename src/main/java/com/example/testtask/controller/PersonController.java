package com.example.testtask.controller;

import com.example.testtask.models.Person;
import com.example.testtask.request.RegisterRequest;
import com.example.testtask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping("/out/{id}")
    public Person Out(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/in")
    public boolean In( @RequestBody RegisterRequest request) {
        service.register(request);
        return true;
    }
}
