package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.bookapispringboot.repositories.BookRepository;

@Controller
@RequestMapping("user/book/")
public class UserController {

    private final BookRepository bookRepository;

    public UserController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("list")
    public String showBooksList(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "user/book/list";
    }

    @GetMapping("{bookId}/show")
    public String showBook(Model model, @PathVariable Long bookId){
        model.addAttribute("book", bookRepository.findById(bookId).get());
        return "user/book/show";
    }

}
