package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.bookapispringboot.models.CurrentUser;
import pl.coderslab.bookapispringboot.models.UserDetails;
import pl.coderslab.bookapispringboot.services.UserDetailsService;
import pl.coderslab.bookapispringboot.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("user/details/")
public class UserDetailsController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("show")
    public String showUser(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("currentUser", currentUser.getUser());
        model.addAttribute("userDetails", userDetailsService.getUserDetails(currentUser.getUser().getId()));
        return "user/details/show";
    }



    @GetMapping("image")
    public String showUploadFile(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("userDetails", userDetailsService.getUserDetails(currentUser.getUser().getId()));
        return "user/details/imageUploadForm";
    }

    @PostMapping("image")
    public String handleImagePost(@RequestParam("imageFile") MultipartFile imageFile, @AuthenticationPrincipal CurrentUser currentUser){
        userDetailsService.saveImageFile(currentUser.getUser().getId(), imageFile);
        return "redirect:/user/details/show";
    }

    @GetMapping("showImage")
    private void renderImageFromDB(@AuthenticationPrincipal CurrentUser currentUser, HttpServletResponse response) throws IOException {
        UserDetails userDetailsDB = userDetailsService.getUserDetails(currentUser.getUser().getId());
        byte[] byteArray = new byte[userDetailsService.getUserDetails(currentUser.getUser().getId()).getImage().length];

        int i=0;
        for (Byte wrappedByte : userDetailsDB.getImage()){
            byteArray[i++]=wrappedByte;
        }

        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        IOUtils.copy(is, response.getOutputStream());
    }

}
