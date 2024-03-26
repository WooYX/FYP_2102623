package edu.my.fyp_2102623.Profile;

import java.util.ArrayList;
import java.util.HashMap;

import edu.my.fyp_2102623.Message;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String bio;
    private int age;
    private ArrayList<String> posts;
    private HashMap<String, ArrayList<Message>> messages;

    // Used for Database Casting, do not delete
    public User() {}

    public User(String firstname, String lastname, String email, String bio, int age, String gender,ArrayList<String> posts,HashMap<String, ArrayList<Message>> messages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.bio = bio;
        this.age = age;
        this.posts = posts;
        this.messages = messages;
    }

    public User(String email) {
        this.email = email;
        this.firstname = "";
        this.lastname = "";
        this.messages = new HashMap<>();
        this.bio = "";
        this.age = 0;
        this.posts = new ArrayList<>();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getFirstname() {return firstname;}

    public String getLastname() {return lastname;}
}

