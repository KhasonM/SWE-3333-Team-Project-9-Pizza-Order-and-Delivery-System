package com.stackunderflow.pizzasystem.model;

public class Customer {
    private int customerId;
    private String username;
    private String firstName;
    private String address;

    public Customer(int customerId, String username, String firstName, String address) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.address = address;
    }

    // Getters for display (P1.5, P1.9)
    public int getCustomerId() { return customerId; }
    public String getUsername() { return username; }
    public String getAddress() { return address; }
    // ... add other necessary getters/setters ...
}