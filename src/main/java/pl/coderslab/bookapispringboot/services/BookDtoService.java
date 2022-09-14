package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.dto.BookDto;
import pl.coderslab.bookapispringboot.models.Book;

public interface BookDtoService {

    Book convertBookDtoIntoBook(BookDto bookDto);
     BookDto convertBookIntoBookDto(Book book);
}
