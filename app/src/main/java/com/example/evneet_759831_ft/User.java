package com.example.evneet_759831_ft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class User implements Serializable {

    private String name;
    private String email;
    private String phone;
    private int random;


    public static ArrayList<User> userDetails = new ArrayList<>();
    public static int[] userImage = {R.drawable.icon01_01,R.drawable.icon01_02,R.drawable.icon01_03,R.drawable.icon01_04,R.drawable.icon01_05};

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.random = generate_number();
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

    public int getRandom() {
        return random;
    }

    public int generate_number(){
        Random random = new Random();
        int rand1 = random.nextInt(5);
        return rand1;
    }


}
