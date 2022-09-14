package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.bookapispringboot.repositories.UserRepository;

@Controller
@RequestMapping("admin/user/")
public class AdminUserController {

    private final UserRepository userRepository;

    public AdminUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("list")
    public String showUsersList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/user/list";
    }

}
