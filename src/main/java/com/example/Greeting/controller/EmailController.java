package com.example.Greeting.controller;

import com.example.Greeting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody Map<String, String> request) {
        String toEmail = request.get("toEmail");
        String subject = request.get("subject");
        String body = request.get("body");

        if (toEmail == null || subject == null || body == null) {
            return "Missing required fields";
        }

        emailService.sendSimpleEmail(toEmail, subject, body);
        return "Email sent successfully!";
    }
}



//package com.example.Greeting.controller;
//
//import com.example.Greeting.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/email")
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    @PostMapping("/send")
//    public String sendEmail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String body) {
//        emailService.sendSimpleEmail(toEmail, subject, body);
//        return "Email sent successfully!";
//    }
//
//    @PostMapping("/sendWithAttachment")
//    public String sendEmailWithAttachment(
//            @RequestParam String toEmail,
//            @RequestParam String subject,
//            @RequestParam String body,
//            @RequestParam String attachmentPath) {
//        emailService.sendEmailWithAttachment(toEmail, subject, body, attachmentPath);
//        return "Email with attachment sent successfully!";
//    }
//}
