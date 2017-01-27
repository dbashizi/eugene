package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found")
    public class NotFoundException extends Exception {

        public NotFoundException() {
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String email, String password) throws Exception {
        Person personEmail = people.findByEmail(email);
        if (personEmail == null) {
            throw new NotFoundException();
        } else if (!password.equals(personEmail.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("person", personEmail);
        return "redirect:/";
    }


    @RequestMapping(path = "/registeraccount", method = RequestMethod.POST)
    public String register(HttpSession session, String firstName, String lastName, String company, String picture,
                           boolean sharePicture, String position, String email, String password) {
     return "redirect:/";
    }
}
