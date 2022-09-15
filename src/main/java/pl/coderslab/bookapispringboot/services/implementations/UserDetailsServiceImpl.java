package pl.coderslab.bookapispringboot.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapispringboot.models.UserDetails;
import pl.coderslab.bookapispringboot.repositories.UserDetailsRepository;
import pl.coderslab.bookapispringboot.services.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void saveUserDetails(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails getUserDetails(Long userId) {
        return userDetailsRepository.findByUserId(userId);
    }
}
