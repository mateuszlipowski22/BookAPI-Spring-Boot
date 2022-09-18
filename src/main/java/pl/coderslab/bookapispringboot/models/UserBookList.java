package pl.coderslab.bookapispringboot.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserBookList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
//    @JoinColumn(name = "book_id")
    private Book book;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedToReadDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishedReadDate;
    private boolean isRead=false;

}
