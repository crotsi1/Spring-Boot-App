package com.javaspringboot.example.project.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

    @Controller
    public class WelcomeController {

        @Value("${welcome.message}")
        private String message;

        private List<String> tasks = Arrays.asList("a", "b",  "c", "d", "e", "f", "g");

        @GetMapping("/${welcome.message}")
        public String main(Model model) {
            model.addAttribute("message", message);
            model.addAttribute("tasks", tasks);
            return "welcome";
        }

        @GetMapping("/")
        public String mainWithParam(
                @RequestParam(name = "name", required = false, defaultValue = "no name")
                        String name, Model model) {
                model.addAttribute("message", name);
                return "welcome";
        }
    }
