package com.felicia.studyapp.models;

import java.time.LocalDate;

import jakarta.persistence.*;

enum Level {
    LOW,
    MEDIUM,
    HIGH
}

enum Size {
    SMALL,
    MEDIUM,
    LARGE
}

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate deadline;

    private Level importance;
    private Level difficulty;
    private Size size; 
    private String tag;

    public Task() {}

    // Constructor
    public Task(String name, String description, LocalDate deadline, Level importance, Level difficulty, Size size, String tag) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.importance = importance;
        this.difficulty = difficulty;
        this.size = size;
        this.tag = tag;
    }

    // Getters and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getDeadline(){
        return deadline;
    }

    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    public Level getImportance(){
        return importance;
    }

    public void setImportance(Level importance){
        this.importance = importance;
    }

    public Level getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(Level difficulty){
        this.difficulty = difficulty;
    }

    public Size getSize(){
        return size;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public String getTag(){
        return tag;
    }

    public void setTag(String tag){
        this.tag = tag;
    }
}
