package pl.coderslab.bookapispringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.services.UserService;

@Controller
public class UserUtilController {

    private final UserService userService;

    public UserUtilController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        userService.saveUser(user);
        return "user";
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveAdmin(user);
        return "user";
    }

}