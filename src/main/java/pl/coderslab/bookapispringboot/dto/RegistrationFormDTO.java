package pl.coderslab.bookapispringboot.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.bookapispringboot.validators.ValidPassword;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationFormDTO {

    @Size(min=2, max=60)
    private String username;

    @Email
    private String email;

    @ValidPassword
    @NotEmpty
    private String password;

    @ValidPassword
    @NotEmpty
    private String password2;

    @AssertTrue
    private boolean confirmation;

    private String city;

    private String street;

    private String houseNumber;

    private String phoneNumber;

    private String aboutMe;
}
