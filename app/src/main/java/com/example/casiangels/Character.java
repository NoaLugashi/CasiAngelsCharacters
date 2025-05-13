package com.example.casiangels;

public class Character {
    String name;
    String description;
    int imageResId;

    public Character(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
}