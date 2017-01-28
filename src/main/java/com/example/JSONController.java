package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class JSONController {

    @Autowired
    PersonRepository people;


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public HashMap login(HttpSession session, String email, String password) throws Exception {
        HashMap login = new HashMap();
        Person personEmail = people.findByEmail(email);
        if (personEmail == null) {
            throw new Exception("that email doesn't exist in our database");
        } else if (!password.equals(personEmail.getPassword())) {
            throw new Exception("Incorrect password");
        }
        login.put(email, password);
        session.setAttribute("person", personEmail);
        return login;
    }


    @RequestMapping(path = "/registeraccount", method = RequestMethod.POST)
    public Person register(@RequestBody Person person) {
        people.save(person);
        return person;
    }

    @RequestMapping(path = "/get_people", method = RequestMethod.GET)
    public List<Person> getPeople() {
        Person personOne = new Person(1, "conor", "thomas", "tiy", "student", "test@gmail.com", "password");
        Person personTwo = new Person(1, "lynsey", "thomas", "buckhead church", "groups director", "test2@gmail.com", "password");

        List<Person> personList = new ArrayList<>();
        personList.add(personOne);
        personList.add(personTwo);

        Iterable<Person> allPeople = people.findAll();
        for (Person person : allPeople) {
            personList.add(person);
        }
        return personList;
    }
}
