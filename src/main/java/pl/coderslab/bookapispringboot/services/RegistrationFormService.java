package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.dto.RegistrationFormDTO;
import pl.coderslab.bookapispringboot.models.User;
import pl.coderslab.bookapispringboot.models.UserDetails;

public interface RegistrationFormService {

    User convertRegistrationFormIntoUser(RegistrationFormDTO registrationFormDTO);

    UserDetails convertRegistrationFormIntoUserDetails(RegistrationFormDTO registrationFormDTO);
}
