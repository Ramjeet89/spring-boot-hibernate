package com.springboot.hibernate.controller;

import com.springboot.hibernate.dao.PersonDAO;
import com.springboot.hibernate.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @PostMapping("/save")
    public String save(@RequestBody Person person) {
        personDAO.savePerson(person);
        return "success";
    }

    @GetMapping("/getAll")
    public List<Person> getAllPerson() {
        return personDAO.getPersons();
    }
}
