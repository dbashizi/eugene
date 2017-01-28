package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class JSONController {

    @Autowired
    PersonRepository people;

    @Autowired
    EventRepository events;

    @PostConstruct
    public void init() {
        if (people.findByEmail("joe@gmail.com") == null) {
            Person person = new Person();
            person.setFirstName("Joe");
            person.setLastName("Thomas");
            person.setEmail("joe@gmail.com");
            person.setCompany("Coke");
            person.setPosition("sales");
            person.setSharePicture(false);
            person.setPassword("password");
            people.save(person);
        }

        if (people.findByEmail("carson@gmail.com") == null) {
            Person person = new Person();
            person.setFirstName("Carson");
            person.setLastName("Wentz");
            person.setEmail("carson@gmail.com");
            person.setCompany("NFL");
            person.setPosition("QB");
            person.setSharePicture(false);
            person.setPassword("password");
            people.save(person);
        }

        if (people.findByEmail("michael@gmail.com") == null) {
            Person person = new Person();
            person.setFirstName("Michael");
            person.setLastName("Jordan");
            person.setEmail("michael@gmail.com");
            person.setCompany("NBA");
            person.setPosition("GOAT");
            person.setSharePicture(false);
            person.setPassword("password");
            people.save(person);
        }

        if (events.findByName("Test123456") == null) {
            Event event = new Event();
            event.setName("Test123456");
            event.setLocation("The Iron Yard");
            event.setAddress("MLK Blvd Atlanta, GA");
            event.setStartTime("Jan 29th @ 4:00pm");
        }

        if (events.findByName("Test2468") == null) {
            Event event = new Event();
            event.setName("Test2468");
            event.setLocation("ATV");
            event.setAddress("3700 Piedmont Road NE Atlanta GA");
            event.setStartTime("Feb 6th @ 4:00pm");
        }

        if (events.findByName("Test1357") == null) {
            Event event = new Event();
            event.setName("Test1357");
            event.setLocation("Georgia Dome");
            event.setAddress("MLK Blvd Atlanta, GA");
            event.setStartTime("Feb 24th 6:00pm");
        }
    }


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
