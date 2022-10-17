package dev.luka.cookbook.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://192.168.1.123:3000")
public class MessageController {

    @GetMapping("/home")
    public String hello() {
        return "Cook book";
    }
}
