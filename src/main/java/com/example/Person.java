package com.example;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

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

    public Person() {
    }

    public Person(Integer id, String firstName, String lastName, String company, String position, String email, String password, boolean sharePicture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.position = position;
        this.email = email;
        this.password = password;
        this.sharePicture = sharePicture;
    }

    public boolean isSharePicture() {
        return sharePicture;
    }

    public void setSharePicture(boolean sharePicture) {
        this.sharePicture = sharePicture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
