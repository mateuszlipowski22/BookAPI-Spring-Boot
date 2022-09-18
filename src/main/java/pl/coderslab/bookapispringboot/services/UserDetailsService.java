package pl.coderslab.bookapispringboot.services;

import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.bookapispringboot.models.UserDetails;

public interface UserDetailsService  {

    void saveUserDetails(UserDetails userDetails);
    UserDetails getUserDetails(Long userId);
    void saveImageFile(Long userId, MultipartFile file);
}
