package com.example.cmpt276a2.Controllers;

import com.example.cmpt276a2.Models.Rectangle;
import com.example.cmpt276a2.Models.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class PageController {
    @Autowired
    private RectangleRepository rectangleRepo;

    @GetMapping("")
    public String home() {
        // Redirects from the default url to the list
        return "redirect:/view";
    }

    @GetMapping("/add")
    public String addRectangle() {
        return "AddRectangle";
    }

    @PostMapping("/add")
    public String addRectangle(@RequestParam Map<String, String> data) {
        String name = data.get("Name");
        int width = Integer.parseInt(data.get("Width"));
        int height = Integer.parseInt(data.get("Height"));
        String colour = data.get("Colour");

        Rectangle rectangle = new Rectangle(name, width, height, colour);
        rectangleRepo.save(rectangle);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewList(Model model) {
        model.addAttribute("rectangles", rectangleRepo.findByOrderByIdAsc());
        return "RectangleList";
    }

    @GetMapping("/view/{id}")
    public String viewRectangle(@PathVariable int id, Model model) {
        Rectangle rectangle = rectangleRepo.findById(id).getFirst();

        if (rectangle == null) {
            return "redirect:/view";
        }

        model.addAttribute("rectangle", rectangle);
        return "ViewRectangle";
    }

    @GetMapping("/edit/{id}")
    public String editRectangle(@PathVariable int id, Model model) {
        Rectangle rectangle = rectangleRepo.findById(id).getFirst();

        if (rectangle == null) {
            return "redirect:/view";
        }

        model.addAttribute("rectangle", rectangle);
        return "EditRectangle";
    }

    @PostMapping("/edit/{id}")
    public String editRectangle(@PathVariable int id, @RequestParam Map<String, String> data) {
        Rectangle rectangle = rectangleRepo.findById(id).getFirst();

        if (rectangle == null) {
            throw new RuntimeException();
        }

        rectangle.setName(data.get("Name"));
        rectangle.setWidth(Integer.parseInt(data.get("Width")));
        rectangle.setHeight(Integer.parseInt(data.get("Height")));
        rectangle.setColour(data.get("Colour"));

        rectangleRepo.save(rectangle);

        return "redirect:/view/" + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRectangle(@PathVariable int id) {
        rectangleRepo.deleteById(id);

        return "RectangleList";
    }
}
