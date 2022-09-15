package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bookapispringboot.dto.RegistrationFormDTO;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.models.UserDetails;
import pl.coderslab.bookapispringboot.services.RegistrationFormService;
import pl.coderslab.bookapispringboot.services.UserDetailsService;
import pl.coderslab.bookapispringboot.services.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final RegistrationFormService registrationFormService;

    public RegistrationController(UserService userService, UserDetailsService userDetailsService, RegistrationFormService registrationFormService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.registrationFormService = registrationFormService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());
        return "static/register";
    }

    @Transactional
    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationFormDTO registrationFormDTO, BindingResult result){
        if (result.hasErrors()) {
            return "static/register";
        }
        UserDetails userToSaveDetails = registrationFormService.convertRegistrationFormIntoUserDetails(registrationFormDTO);
        User userToSave=registrationFormService.convertRegistrationFormIntoUser(registrationFormDTO);
        userToSaveDetails.setUser(userToSave);
        userToSave.setUserDetails(userToSaveDetails);
        userService.saveUser(userToSave);
        return "redirect:/login";
    }
}
