package com.example.atm_v2;

public class Customer {
    //Instance variables for the class Customer
    private String name;
    private String pin;

    //The constructor for the Customer class
    public Customer (String username, String password) {
        name = username;
        pin = password;
    }

    //Allows for the user's pin to be updated
    public void setPin(String newPin) {
        pin = newPin;
    }

    //returns the user's name
    public String getName() {
        return name;
    }

    //returns the user's current pin
    public String getPin() {
        return pin;
    }
}

