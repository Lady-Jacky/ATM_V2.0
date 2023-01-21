package com.example.atm_v2;

public class Customer {
    private String name;
    private String pin;

    public Customer (String username, String password) {
        name = username;
        pin = password;
    }

    public void setPin(String newPin) {
        pin = newPin;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }
}

