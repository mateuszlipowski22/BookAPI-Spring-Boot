package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.bookapispringboot.models.Book;
import pl.coderslab.bookapispringboot.repositories.BookRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/book/")
public class AdminController {

    private final BookRepository bookRepository;

    public AdminController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("list")
    public String showBooksList(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "admin/book/list";
    }

    @GetMapping("{bookId}/show")
    public String showBook(Model model, @PathVariable Long bookId){
        model.addAttribute("book", bookRepository.findById(bookId).get());
        return "admin/book/show";
    }

    @GetMapping("add")
    public String showAddBookForm(Model model){
        model.addAttribute("book", new Book());
        return "admin/book/add";
    }

    @PostMapping("add")
    public String processAddBook(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/book/add";
        }
        bookRepository.save(book);
        return "redirect:/admin/book/list";
    }

    @GetMapping("{bookId}/edit")
    public String showEditBookForm(@PathVariable Long bookId, Model model){
        model.addAttribute("book", bookRepository.findById(bookId).get());
        return "admin/book/edit";
    }

    @PostMapping("{bookId}/edit")
    public String processEditBook(@Valid Book book, BindingResult bindingResult, @PathVariable Long bookId){
        if(bindingResult.hasErrors()){
            return "admin/book/edit";
        }
        Book bookDB=bookRepository.findById(bookId).get();
        bookDB.setAuthor(book.getAuthor());
        bookDB.setIsbn(book.getIsbn());
        bookDB.setPublisher(book.getPublisher());
        bookDB.setTitle(book.getTitle());
        bookDB.setType(book.getType());
        bookRepository.save(bookDB);
        return "redirect:/admin/book/list";
    }

    @GetMapping("{bookId}/delete")
    public String showDeleteBookForm(Model model, @PathVariable Long bookId) {
        model.addAttribute("book", bookRepository.findById(bookId).get());
        return "admin/book/delete";
    }

    @PostMapping("/delete")
    public String processDeleteBook(Long id) {
        bookRepository.deleteById(id);
        return "redirect:/admin/book/list";
    }

}
