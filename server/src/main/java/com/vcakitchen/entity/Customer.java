package com.vcakitchen.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;


//Entity annotation on the class is used to create a table on the database with the given name that you give.
@Entity(name = "costumer")
public class Customer {
    //All the attributes iof this class they will become the columns of the table is the database
    //Id will be auto generated
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer costumerID ;
    @Column
    private String firstName ;
    @Column
    private String lastName;
    @Column
    private String phoneNumber;
    @Column
    private int numOfP;
    @Column
    private Date date;
    @Column
    private Time time;

    //All the getters and setters because all the variables are Private
    public int getCostumerID() {
        return costumerID;
    }

    public void setCostumerID(int costumerID) {
        this.costumerID = costumerID;
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

    //Equals and HashCode sow we can compare the objects between them.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer costumer = (Customer) o;
        return getCostumerID() == costumer.getCostumerID() && getNumOfP() == costumer.getNumOfP() && Objects.equals(getFirstName(), costumer.getFirstName()) && Objects.equals(getLastName(), costumer.getLastName()) && Objects.equals(getPhoneNumber(), costumer.getPhoneNumber()) && Objects.equals(getDate(), costumer.getDate()) && Objects.equals(getTime(), costumer.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCostumerID(), getFirstName(), getLastName(), getPhoneNumber(), getNumOfP(), getDate(), getTime());
    }

    //ToString so we will be able to display the object.
    @Override
    public String toString() {
        return "Costumer{" +
                "costumerID=" + costumerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numOfP=" + numOfP +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
