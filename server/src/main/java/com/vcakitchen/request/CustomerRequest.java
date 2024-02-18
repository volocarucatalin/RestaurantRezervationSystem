package com.vcakitchen.request;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//This is a class only to show how is the rule tom create a customer as a json object
public class CustomerRequest implements Serializable {

    private int id;
    private String firstName ;
    private String lastName;
    private String phoneNumber;
    private int numOfP;
    private Date date;
    private Time time;

    public CustomerRequest() {
    }

    public CustomerRequest(String firstName, String lastName, String phoneNumber, int numOfP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.numOfP = numOfP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumOfP() {
        return numOfP;
    }

    public void setNumOfP(int numOfP) {
        this.numOfP = numOfP;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
