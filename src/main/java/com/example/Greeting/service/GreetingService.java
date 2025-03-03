package com.example.Greeting.service;


//UC4

import com.example.Greeting.model.Greeting;
import com.example.Greeting.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public String generateGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }
}


//UC3
//import com.example.Greeting.model.Greeting;
//import com.example.Greeting.model.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//
//    public Greeting getGreeting(User user) {
//        if (user.getFirstName() != null && user.getLastName() != null) {
//            return new Greeting("Hello, " + user.getFirstName() + " " + user.getLastName() + "!");
//        } else if (user.getFirstName() != null) {
//            return new Greeting("Hello, " + user.getFirstName() + "!");
//        } else if (user.getLastName() != null) {
//            return new Greeting("Hello, " + user.getLastName() + "!");
//        } else {
//            return new Greeting("Hello World!");
//        }
//    }
//}




//UC2
//import com.example.Greeting.model.Greeting;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//
//    public Greeting getSimpleGreeting() {
//        return new Greeting("Hello World");
//    }
//
//    public Greeting getPersonalizedGreeting(String name) {
//        return new Greeting("Hello, " + name + "!");
//    }
//
//    public Greeting createGreeting(String name) {
//        return new Greeting("Greeting created for " + name);
//    }
//
//    public Greeting updateGreeting(String name) {
//        return new Greeting("Greeting updated for " + name);
//    }
//
//    public Greeting deleteGreeting(String name) {
//        return new Greeting("Greeting deleted for " + name);
//    }
//}
