package com.example.eztask;


public class Task {
    public final String name;
    public final String description;
    public final int stars;
    public final long createdAt;

    public Task(String name, String description, int stars, long createdAt) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.createdAt = createdAt;
    }
}
