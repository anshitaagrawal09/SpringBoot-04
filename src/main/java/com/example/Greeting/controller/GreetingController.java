package com.example.Greeting.controller;

import com.example.Greeting.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/{name}")
    public Greeting getGreeting(@PathVariable String name) {
        return new Greeting("Hello, " + name + "!");
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody String name) {
        return new Greeting("Greeting created for " + name);
    }

    @PutMapping("/{name}")
    public Greeting updateGreeting(@PathVariable String name) {
        return new Greeting("Greeting updated for " + name);
    }

    @DeleteMapping("/{name}")
    public Greeting deleteGreeting(@PathVariable String name) {
        return new Greeting("Greeting deleted for " + name);
    }
}
