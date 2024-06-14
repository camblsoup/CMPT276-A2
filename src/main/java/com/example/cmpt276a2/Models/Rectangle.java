package com.example.cmpt276a2.Models;
import jakarta.persistence.*;

@Entity
@Table(name="rectangles")
public class Rectangle {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int width;
    private int height;
    private String colour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Rectangle(String name, int width, int height, String colour) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public Rectangle() {
    }
}
