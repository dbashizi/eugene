package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EugeneController {
    @Autowired
    EventRepository events;

    @Autowired
    PersonRepository people;

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String home(Model model) {
        Iterable<Event> allEvents = events.findAll();
        List<Event> eventList = new ArrayList<>();
        for (Event event : allEvents) {
            eventList.add(event);
        }
        model.addAttribute("events", eventList);

        return "home";
    }

    // make this conditional on the selectedEvent NOT READY YET --- OPTIONAL
    @RequestMapping(path = "/display-attendance", method = RequestMethod.GET)
    public String displayAttendance(Model model) {
        Iterable<Person> allPeople = people.findAll();
        List<Person> peopleList = new ArrayList<>();
        for (Person person : allPeople) {
            peopleList.add(person);
        }
        model.addAttribute("people", peopleList);
        return "home";
    }

    @RequestMapping(path = "/add-event", method = RequestMethod.POST)
    public String addEvent(String name, String location, String address, Timestamp eventTime) {
        Event event = new Event(null, name, location, address, eventTime);
        events.save(event);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteEvent(Model model, Integer eventId) {
        if (eventId != null) {
            events.delete(eventId);
        }

        return "redirect:/admin";
    }
}
