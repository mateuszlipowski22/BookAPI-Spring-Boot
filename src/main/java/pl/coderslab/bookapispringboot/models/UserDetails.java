package pl.coderslab.bookapispringboot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Slf4j
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

    private LocalDateTime createdOn;

    @Lob
    private Byte[] image;

    @PrePersist
    public void prePersist() throws IOException {
        createdOn = LocalDateTime.now();
        image= ArrayUtils.toObject(Files.readAllBytes(Paths.get("src/main/webapp/WEB-INF/views/static/user2.png")));

    }
}
