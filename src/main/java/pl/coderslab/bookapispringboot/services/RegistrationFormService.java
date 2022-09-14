package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.dto.RegistrationFormDTO;
import pl.coderslab.bookapispringboot.models.User;

public interface RegistrationFormService {

    User convertRegistrationFormIntoUser(RegistrationFormDTO registrationFormDTO);

}
