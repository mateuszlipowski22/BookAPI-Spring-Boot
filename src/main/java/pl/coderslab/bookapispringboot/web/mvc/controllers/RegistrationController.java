package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bookapispringboot.dto.RegistrationFormDTO;
import pl.coderslab.bookapispringboot.services.RegistrationFormService;
import pl.coderslab.bookapispringboot.services.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final RegistrationFormService registrationFormService;

    public RegistrationController(UserService userService, RegistrationFormService registrationFormService) {
        this.userService = userService;
        this.registrationFormService = registrationFormService;
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
        return "static/register";
    }


    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationFormDTO registrationFormDTO, BindingResult result){
        if (result.hasErrors()) {
            return "static/register";
        }
        userService.saveUser(registrationFormService.convertRegistrationFormIntoUser(registrationFormDTO));
        return "redirect:/login";
    }
}
