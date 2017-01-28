package com.example;

import java.util.ArrayList;

/**
 * Created by conorthomas on 1/28/17.
 */
public class Request {
    private ArrayList<Person> incoming;
    private ArrayList<Person> outgoing;

    public Request() {
    }

    public Request(ArrayList<Person> incoming, ArrayList<Person> outgoing) {
        this.incoming = incoming;
        this.outgoing = outgoing;
    }

    public ArrayList<Person> getIncoming() {
        return incoming;
    }

    public void setIncoming(ArrayList<Person> incoming) {
        this.incoming = incoming;
    }

    public ArrayList<Person> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(ArrayList<Person> outgoing) {
        this.outgoing = outgoing;
    }
}
