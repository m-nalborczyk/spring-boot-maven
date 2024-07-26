package spring.course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.course.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private Map<String, UserModel> userMap = new HashMap<>();

    public UserController() {
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 5432));
    }

    @GetMapping("/getUser/{userName}")
    public UserModel getUser(@PathVariable("userName")String userName){
        return userMap.get(userName);
    }

}
