package pl.coderslab.bookapispringboot.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapispringboot.dto.BookDto;
import pl.coderslab.bookapispringboot.models.Book;
import pl.coderslab.bookapispringboot.services.BookDtoService;

@Service
public class BookDtoServiceImpl implements BookDtoService {

    @Override
    public Book convertBookDtoIntoBook(BookDto bookDto) {
        Book book = new Book();
        book.setType(bookDto.getType());
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());
        return book;
    }

    @Override
    public BookDto convertBookIntoBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setType(book.getType());
        bookDto.setTitle(book.getTitle());
        bookDto.setPublisher(book.getPublisher());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }
}
