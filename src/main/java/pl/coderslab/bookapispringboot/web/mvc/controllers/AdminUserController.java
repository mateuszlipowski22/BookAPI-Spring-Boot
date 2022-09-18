package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.bookapispringboot.dto.BookDto;
import pl.coderslab.bookapispringboot.models.Book;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.repositories.RoleRepository;
import pl.coderslab.bookapispringboot.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/user/")
public class AdminUserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public AdminUserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("list")
    public String showUsersList(Model model){
        model.addAttribute("users", userRepository.findAllByRolesContaining(roleRepository.findByName("ROLE_USER")));
        return "admin/user/list";
    }

    @GetMapping("{userId}/delete")
    public String showDeleteUserForm(Model model, @PathVariable Long userId) {
        model.addAttribute("user", userRepository.findById(userId).get());
        return "admin/user/delete";
    }

    @PostMapping("/delete")
    public String processDeleteUser(Long id) {
        userRepository.deleteUserRole(id);
        userRepository.deleteById(id);
        return "redirect:/admin/user/list";
    }

    @GetMapping("{userId}/edit")
    public String showEditUserForm(@PathVariable Long userId, Model model){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "admin/user/edit";
    }

    @PostMapping("{userId}/edit")
    public String processEditUser(@Valid User user, BindingResult bindingResult, @PathVariable Long userId){
        if(bindingResult.hasErrors()){
            return "admin/book/edit";
        }
        User userDB=userRepository.findById(userId).get();
        userDB.setEmail(user.getEmail());
        userDB.setUsername(user.getUsername());
        userRepository.save(userDB);
        return "redirect:/admin/user/list";
    }


    @GetMapping("{userId}/show")
    public String showUser(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "admin/user/show";
    }
}
