package com.example.Greeting.service;

import com.example.Greeting.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getSimpleGreeting() {
        return new Greeting("Hello World");
    }

    public Greeting getPersonalizedGreeting(String name) {
        return new Greeting("Hello, " + name + "!");
    }

    public Greeting createGreeting(String name) {
        return new Greeting("Greeting created for " + name);
    }

    public Greeting updateGreeting(String name) {
        return new Greeting("Greeting updated for " + name);
    }

    public Greeting deleteGreeting(String name) {
        return new Greeting("Greeting deleted for " + name);
    }
}
