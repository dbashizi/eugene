package com.example;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String address;

//    @Column(nullable = false)
//    private java.sql.Timestamp eventTime;


    public Event() {
    }

    public Event(Integer id, String name, String startTime, String location, String address) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.location = location;
        this.address = address;
        //this.eventTime =eventTime;
    }

//    public Timestamp getEventTime() {
//        return eventTime;
//    }
//
//    public void setEventTime(Timestamp eventTime) {
//        this.eventTime = eventTime;
//    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
