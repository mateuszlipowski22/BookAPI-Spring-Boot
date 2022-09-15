package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.models.UserDetails;

public interface UserDetailsService  {

    void saveUserDetails(UserDetails userDetails);
    UserDetails getUserDetails(Long userId);

}
