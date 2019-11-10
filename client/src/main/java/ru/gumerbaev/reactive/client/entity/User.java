package ru.gumerbaev.reactive.client.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    Integer id;
    String firstName;
    String lastName;
    String email;
    Date createdOn;
    Date lastLogin;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
