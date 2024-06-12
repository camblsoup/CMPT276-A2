package com.example.cmpt276a2.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @DeleteMapping("/deleteRectangle")
    public String deleteRectangle() {
        // Code to remove Rectangle from database
        return "Rectangle deleted";
    }
}
