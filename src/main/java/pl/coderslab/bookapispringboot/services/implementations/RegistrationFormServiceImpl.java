package pl.coderslab.bookapispringboot.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapispringboot.dto.RegistrationFormDTO;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.models.UserDetails;
import pl.coderslab.bookapispringboot.services.RegistrationFormService;

@Service
public class RegistrationFormServiceImpl implements RegistrationFormService {
    @Override
    public User convertRegistrationFormIntoUser(RegistrationFormDTO registrationFormDTO) {
        User newUser = new User();
        newUser.setUsername(registrationFormDTO.getUsername());
        newUser.setPassword(registrationFormDTO.getPassword());
        newUser.setEmail(registrationFormDTO.getEmail());
        return newUser;
    }

    @Override
    public UserDetails convertRegistrationFormIntoUserDetails(RegistrationFormDTO registrationFormDTO) {
        UserDetails newUserDetails = new UserDetails();
        newUserDetails.setCity(registrationFormDTO.getCity());
        newUserDetails.setStreet(registrationFormDTO.getStreet());
        newUserDetails.setHouseNumber(registrationFormDTO.getHouseNumber());
        newUserDetails.setPhoneNumber(registrationFormDTO.getPhoneNumber());
        newUserDetails.setAboutMe(registrationFormDTO.getAboutMe());

        return newUserDetails;
    }
}
