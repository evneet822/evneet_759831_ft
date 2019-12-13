package com.example.evneet_759831_ft;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private String phone;

    public static ArrayList<User> userDetails = new ArrayList<>();

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
