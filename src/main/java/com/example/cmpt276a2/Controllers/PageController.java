package com.example.cmpt276a2.Controllers;

import com.example.cmpt276a2.Models.Rectangle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    private final List<Rectangle> rectangles = new ArrayList<>();

    PageController() {
        rectangles.add(new Rectangle("Rectangle 1", 10, 20, "#FF0000"));
        rectangles.add(new Rectangle("Rectangle 2", 20, 30, "#00FF00"));
        rectangles.add(new Rectangle("Rectangle 3", 30, 40, "#0000FF"));
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("rectangles", rectangles);
        return "RectangleList";
    }

    @GetMapping("/addRectangle")
    public String addRectangle() {
        return "AddRectangle";
    }

    @PostMapping("/addRectangle")
    public String addRectangle(String name, int width, int height, String color) {
        rectangles.add(new Rectangle(name, width, height, color));
        return "redirect:/";
    }
}
