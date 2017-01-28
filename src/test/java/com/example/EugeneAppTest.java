package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EugeneAppTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Autowired
    PersonRepository people;

    @Autowired
    EventRepository events; }

//    @Test
//    public void testAddPersonToDatabase() throws Exception {
//        Iterable<Person> allPeople = people.findAll();
//        int initSize = 0;
//        for (Person person : allPeople) {
//            initSize++;
//        }
//
//        Person testPerson = new Person(null, "Conor", "Thomas", "The Iron Yard",
//                "Student", "m.conorthomas@gmail.com", "092193", false);
//        people.save(testPerson);
//
//        assertNotNull(testPerson.getId());
//        System.out.println("testPerson: " + testPerson.getId());
//
//        allPeople = people.findAll();
//        int afterSize = 0;
//        for (Person person : allPeople) {
//            afterSize++;
//        }
//
//        assertEquals(initSize + 1, afterSize);
//
//        people.delete(testPerson);
//
//        allPeople = people.findAll();
//        int afterDeleteSize = 0;
//        for (Person person : allPeople) {
//            afterDeleteSize++;
//        }
//
//        assertEquals(initSize, afterDeleteSize);
//    }
//
//    @Test
//    public void testAddEventToDatabase() throws Exception {
//        Iterable<Event> allEvents = events.findAll();
//        int initSize = 0;
//        for (Event event : allEvents) {
//            initSize++;
//        }
//
//        Event testEvent = new Event(null, "Java Crash Course", "TIY", "MLK BLVD", java.sql.Timestamp.from(Instant.now()));
//        events.save(testEvent);
//
//        assertNotNull(testEvent.getId());
//        System.out.println("testEvent: " + testEvent.getId());
//
//        allEvents = events.findAll();
//        int afterSize = 0;
//        for (Event event : allEvents) {
//            afterSize++;
//        }
//
//        assertEquals(initSize + 1, afterSize);
//
//        events.delete(testEvent);
//
//        allEvents = events.findAll();
//        int afterDeleteSize = 0;
//        for (Event event : allEvents) {
//            afterDeleteSize++;
//        }
//
//        assertEquals(initSize, afterDeleteSize);
//    }
//
//}
