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


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Person login(@RequestBody RequestLogin requestLogin) throws Exception {
        //HashMap login = new HashMap();
        Person person = people.findByEmail(requestLogin.getEmail());
        if (person == null) {
            throw new Exception("that email doesn't exist");
        }
        else if (!requestLogin.getPassword().equals(person.getPassword())) {
            throw new Exception("Incorrect password");
        } 
        return person;
    }


    @RequestMapping(path = "/registeraccount", method = RequestMethod.POST)
    public Person register(@RequestBody Person person) {
        people.save(person);
        return person;
    }

    @RequestMapping(path = "/get_people", method = RequestMethod.GET)
    public List<Person> getPeople() {
        Person personOne = new Person(1, "conor", "thomas", "tiy", "student", "test@gmail.com", "password", false);
        Person personTwo = new Person(2, "lynsey", "thomas", "buckhead church", "groups director", "test2@gmail.com", "password", false);

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
