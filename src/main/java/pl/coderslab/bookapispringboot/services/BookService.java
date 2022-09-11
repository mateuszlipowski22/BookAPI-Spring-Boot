package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.models.Book;

import java.util.List;

public interface BookService {


    List<Book> getBooksList();
    Book getBookById(Long id);
    void updateBookById(Book book);
    void deleteBookById(Long id);
    void addBook(Book book);

}
