package spring.course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){
        return "<html><body><h1>The browser renders the HTML</h1></body></html>";
    }

}
