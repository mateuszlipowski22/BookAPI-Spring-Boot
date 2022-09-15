package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bookapispringboot.models.CurrentUser;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.repositories.UserDetailsRepository;
import pl.coderslab.bookapispringboot.services.UserDetailsService;
import pl.coderslab.bookapispringboot.services.UserService;

@Controller
@RequestMapping("user/details/")
public class UserDetailsController {

    private final UserService userService;

    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public String showUser(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("currentUser", currentUser.getUser());
        return "user/details/show";
    }

}
