package pl.coderslab.bookapispringboot.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BookDto {

    private Long id;

    @NotEmpty
    private String isbn;

    @NotEmpty
    @Size(min = 2)
    private String title;

    @NotEmpty
    @Size(min = 2)
    private String author;

    @NotEmpty
    @Size(min = 2)
    private String publisher;

    @NotEmpty
    private String type;

}
