package com.example;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Set;


@Entity
@Table(name = "events")
public class Event {



    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Timestamp eventTime;

    public Event() {
    }

    public Event(Integer id, String name, String location, String address, Timestamp eventTime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.eventTime =eventTime;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
//import java.util.Set;
//
//        import javax.persistence.CascadeType;
//        import javax.persistence.Column;
//        import javax.persistence.Entity;
//        import javax.persistence.GeneratedValue;
//        import javax.persistence.GenerationType;
//        import javax.persistence.Id;
//        import javax.persistence.JoinColumn;
//        import javax.persistence.JoinTable;
//        import javax.persistence.ManyToMany;
//
//@Entity
//public class Event
//{
//    private Long eventId;
//    private String name;
//    private Set<Person> persons;
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="event_id")
//    public Long getEventId()
//    {
//        return eventId;
//    }
//    public void setEventId(Long eventId)
//    {
//        this.eventId = eventId;
//    }
//
//    @Column(name="event_name")
//    public String getName()
//    {
//        return name;
//    }
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="person_event", joinColumns=@JoinColumn(name="event_id"), inverseJoinColumns=@JoinColumn(name="person_id"))
//    public Set<Person> getPersons()
//    {
//        return persons;
//    }
//    public void setPersons(Set<Person> persons)
//    {
//        this.persons = persons;
//    }
//}
