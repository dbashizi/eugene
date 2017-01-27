package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testAddPersonToDatabase() throws Exception {
        Iterable<Person> allPeople = people.findAll();
        int initSize = 0;
        for (Person person : allPeople) {
            initSize++;
        }

        Person testPerson = new Person(null, "Conor", "Thomas", "The Iron Yard",
                "Student", "m.conorthomas@gmail.com", "092193");
        people.save(testPerson);

        assertNotNull(testPerson.getId());
        System.out.println("testPerson: " + testPerson.getId());

        allPeople = people.findAll();
        int afterSize = 0;
        for (Person person : allPeople) {
            afterSize++;
        }

        assertEquals(initSize + 1, afterSize);

        people.delete(testPerson);

        allPeople = people.findAll();
        int afterDeleteSize = 0;
        for (Person person : allPeople) {
            afterDeleteSize++;
        }

        assertEquals(initSize, afterDeleteSize);
    }
}