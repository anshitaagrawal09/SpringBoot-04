package com.example.Greeting.controller;

//UC3
import com.example.Greeting.model.Greeting;
import com.example.Greeting.model.User;
import com.example.Greeting.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting getGreeting(@RequestBody User user) {
        return greetingService.getGreeting(user);
    }
}
//Test Using curl
//Case 1: Both First Name and Last Name
//sh
//curl -X POST "http://localhost:8080/greetings" -H "Content-Type: application/json" -d '{"firstName":"Anshita","lastName":"Agrawal"}'
//🔹 Response:
//
//json
//{"message":"Hello, Anshita Agrawal!"}
//Case 2: Only First Name
//sh
//curl -X POST "http://localhost:8080/greetings" -H "Content-Type: application/json" -d '{"firstName":"Anshita"}'
//🔹 Response:
//json
//{"message":"Hello, Anshita!"}
//Case 3: Only Last Name
//sh
//curl -X POST "http://localhost:8080/greetings" -H "Content-Type: application/json" -d '{"lastName":"Agrawal"}'
//🔹 Response:
//json
//{"message":"Hello, Agrawal!"}
//Case 4: No Name Provided
//sh
//curl -X POST "http://localhost:8080/greetings" -H "Content-Type: application/json" -d '{}'
//🔹 Response:
//json
//{"message":"Hello, World!"}

//UC2
//import com.example.Greeting.model.Greeting;
//import com.example.Greeting.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greetings")
//public class GreetingController {
//
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @GetMapping("/hello")
//    public Greeting getSimpleGreeting() {
//        return greetingService.getSimpleGreeting();
//    }
//
//    @GetMapping("/{name}")
//    public Greeting getGreeting(@PathVariable String name) {
//        return greetingService.getPersonalizedGreeting(name);
//    }
//
//    @PostMapping
//    public Greeting createGreeting(@RequestBody String name) {
//        return greetingService.createGreeting(name);
//    }
//
//    @PutMapping("/{name}")
//    public Greeting updateGreeting(@PathVariable String name) {
//        return greetingService.updateGreeting(name);
//    }
//
//    @DeleteMapping("/{name}")
//    public Greeting deleteGreeting(@PathVariable String name) {
//        return greetingService.deleteGreeting(name);
//    }
//}
//Test Using curl
//✅ Get Simple Greeting (Hello World)
//sh
//Copy
//Edit
//curl -X GET http://localhost:8080/greetings/hello
//📌 Response:
//
//json
//Copy
//Edit
//{"message": "Hello World"}
//✅ Get Personalized Greeting
//sh
//Copy
//Edit
//curl -X GET http://localhost:8080/greetings/John
//📌 Response:
//
//json
//Copy
//Edit
//{"message": "Hello, John!"}
//✅ Create a Greeting
//sh
//Copy
//Edit
//curl -X POST http://localhost:8080/greetings -H "Content-Type: application/json" -d '"John"'
//📌 Response:
//
//json
//Copy
//Edit
//{"message": "Greeting created for John"}
//✅ Update a Greeting
//sh
//Copy
//Edit
//curl -X PUT http://localhost:8080/greetings/John
//📌 Response:
//
//json
//Copy
//Edit
//{"message": "Greeting updated for John"}
//✅ Delete a Greeting
//sh
//Copy
//Edit
//curl -X DELETE http://localhost:8080/greetings/John
//📌 Response:
//
//json
//Copy
//Edit
//{"message": "Greeting deleted for John"}


//UC1
//import com.example.Greeting.model.Greeting;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greetings")
//public class GreetingController {
//
//    @GetMapping("/{name}")
//    public Greeting getGreeting(@PathVariable String name) {
//        return new Greeting("Hello, " + name + "!");
//    }
//
//    @PostMapping
//    public Greeting createGreeting(@RequestBody String name) {
//        return new Greeting("Greeting created for " + name);
//    }
//
//    @PutMapping("/{name}")
//    public Greeting updateGreeting(@PathVariable String name) {
//        return new Greeting("Greeting updated for " + name);
//    }
//
//    @DeleteMapping("/{name}")
//    public Greeting deleteGreeting(@PathVariable String name) {
//        return new Greeting("Greeting deleted for " + name);
//    }
//}
//To Run
//Test Using curl
//Run the application and test with the following curl commands:
//✅ GET Request
//sh
//curl -X GET http://localhost:8080/greetings/John
// Response:
//json
//{"message": "Hello, John!"}
//✅ POST Request
//sh
//curl -X POST http://localhost:8080/greetings -H "Content-Type: application/json" -d '"John"'
//📌 Response:
//json
//{"message": "Greeting created for John"}
//✅ PUT Request
//sh
//curl -X PUT http://localhost:8080/greetings/John
//📌 Response:
//json
//{"message": "Greeting updated for John"}
//✅ DELETE Request
//sh
//curl -X DELETE http://localhost:8080/greetings/John
//📌 Response:
//json
//{"message": "Greeting deleted for John"}