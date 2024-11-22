package com.felicia.studyapp.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String username;
    private String email;
    private String passwordHash;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    // Constructor
    public User(String name, String username, String email, String passwordHash) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        tasks = new ArrayList<>();
    }

    // Getters and setters
    public Long getId(){
        return userId;
    }

    public void setId(Long id){
        this.userId = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUserame(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return passwordHash;
    }

    public void setPassword(String password){
        this.passwordHash = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTasks(Task task){
        this.tasks.add(task);
    }
}