package it.academy.rent.car.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellController {
    @GetMapping("/")
    public String hello(Model model) {
        return "hello";
    }
}
