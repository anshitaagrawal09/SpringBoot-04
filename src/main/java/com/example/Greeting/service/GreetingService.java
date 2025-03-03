package com.example.Greeting.service;


//UC3
import com.example.Greeting.model.Greeting;
import com.example.Greeting.model.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getGreeting(User user) {
        if (user.getFirstName() != null && user.getLastName() != null) {
            return new Greeting("Hello, " + user.getFirstName() + " " + user.getLastName() + "!");
        } else if (user.getFirstName() != null) {
            return new Greeting("Hello, " + user.getFirstName() + "!");
        } else if (user.getLastName() != null) {
            return new Greeting("Hello, " + user.getLastName() + "!");
        } else {
            return new Greeting("Hello World!");
        }
    }
}




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
