package pl.coderslab.bookapispringboot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String city;

    private String street;

    private String houseNumber;

    private String phoneNumber;

    private String aboutMe;
}
