package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name = "people")
public class Person {

    @ManyToMany
    @JoinTable(name="person_event", joinColumns=@JoinColumn(name="person_id"),
            inverseJoinColumns=@JoinColumn(name="event_id"))
    private Set<Event> events;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String company;

    // picture?
    @Column(nullable = false)
    private boolean sharePicture;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Long eventId;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String company, String position, String email, String password, boolean sharePicture, Long eventId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.position = position;
        this.email = email;
        this.password = password;
        this.sharePicture = sharePicture;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public boolean isSharePicture() {
        return sharePicture;
    }

    public void setSharePicture(boolean sharePicture) {
        this.sharePicture = sharePicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

