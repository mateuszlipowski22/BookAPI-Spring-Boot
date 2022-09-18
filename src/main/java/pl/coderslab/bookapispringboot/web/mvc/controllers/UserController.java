package pl.coderslab.bookapispringboot.web.mvc.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.bookapispringboot.dto.BookDto;
import pl.coderslab.bookapispringboot.models.Book;
import pl.coderslab.bookapispringboot.models.CurrentUser;
import pl.coderslab.bookapispringboot.models.UserBookList;
import pl.coderslab.bookapispringboot.repositories.BookRepository;
import pl.coderslab.bookapispringboot.services.implementations.UserBookListServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("user/book/")
public class UserController {

    private final BookRepository bookRepository;
    private final UserBookListServiceImpl userBookListService;

    public UserController(BookRepository bookRepository, UserBookListServiceImpl userBookListService) {
        this.bookRepository = bookRepository;
        this.userBookListService = userBookListService;
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

    @GetMapping("userBookList")
    public String showUserBooksList(Model model,@AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("userBookList", userBookListService.findUserBookListByUserId(currentUser.getUser().getId()));
        return "user/book/userBookList";
    }

    @GetMapping("{bookId}/add")
    public String addToMyBookList(@PathVariable Long bookId, @AuthenticationPrincipal CurrentUser currentUser){
        UserBookList userBookListTosave = new UserBookList();
        userBookListTosave.setUser(currentUser.getUser());
        userBookListTosave.setBook(bookRepository.findById(bookId).get());
        userBookListService.saveUserBookList(userBookListTosave);
        return "redirect:/user/book/userBookList";
    }

    @PostMapping("/delete")
    public String processDeleteUserBookListElement(Long id) {
        userBookListService.deleteUserBookListById(id);
        return "redirect:/user/book/userBookList";
    }

    @GetMapping("{userBookListElementId}/delete")
    public String showDeleteUserBookListElementForm(Model model, @PathVariable Long userBookListElementId) {
        model.addAttribute("userBookListElement", userBookListService.findByUserBookListId(userBookListElementId));
        return "user/book/delete";
    }


    @GetMapping("{userBookListElementId}/planReading")
    public String showReadPlanningForm(@PathVariable Long userBookListElementId, Model model){
        model.addAttribute("userBookList", userBookListService.findByUserBookListId(userBookListElementId));
        return "user/book/setReadPlanning";
    }

    @PostMapping("{userBookListElementId}/planReading")
    public String processReadPlanning(@Valid UserBookList userBookList, BindingResult bindingResult, @PathVariable Long userBookListElementId){
        if(bindingResult.hasErrors()){
            return "user/book/setReadPlanning";
        }
        UserBookList userBookListDB=userBookListService.findByUserBookListId(userBookListElementId);
        userBookListDB.setPlannedToReadDate(userBookList.getPlannedToReadDate());
        userBookListService.saveUserBookList(userBookListDB);
        return "redirect:/user/book/userBookList";
    }


    @GetMapping("{userBookListElementId}/setFinishReading")
    public String showReadFinishForm(@PathVariable Long userBookListElementId, Model model){
        model.addAttribute("userBookList", userBookListService.findByUserBookListId(userBookListElementId));
        return "user/book/setFinishReading";
    }

    @PostMapping("{userBookListElementId}/setFinishReading")
    public String processReadFinish(@Valid UserBookList userBookList, BindingResult bindingResult, @PathVariable Long userBookListElementId){
        if(bindingResult.hasErrors()){
            return "user/book/setFinishReading";
        }
        UserBookList userBookListDB=userBookListService.findByUserBookListId(userBookListElementId);
        userBookListDB.setFinishedReadDate(userBookList.getFinishedReadDate());
        userBookListDB.setRead(true);
        userBookListService.saveUserBookList(userBookListDB);
        return "redirect:/user/book/userBookList";
    }
}
