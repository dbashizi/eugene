package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by conorthomas on 1/26/17.
 */

@RestController
public class JSONController {

    @Autowired
    PersonRepository people;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public HttpSession login(HttpSession session, String email, String password) throws Exception {
        Person personEmail = people.findByEmail(email);
        if (personEmail == null) {
            try {
                throw new Exception("that email address does not exist in our database");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (!password.equals(personEmail.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("person", personEmail);
        return session;
    }


    @RequestMapping(path = "/registeraccount", method = RequestMethod.POST)
    public String register(HttpSession session, String firstName, String lastName, String company, String picture,
                           boolean sharePicture, String position, String email, String password) {
     return "redirect:/";
    }
}
