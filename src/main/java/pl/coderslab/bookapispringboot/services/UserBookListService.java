package pl.coderslab.bookapispringboot.services;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapispringboot.models.UserBookList;

import java.util.List;

public interface UserBookListService {

    List<UserBookList> findUserBookListByUserId(Long userId);
    void saveUserBookList(UserBookList userBookList);
    void deleteUserBookListById(Long userBookListId);
    UserBookList findByUserBookListId(Long userBookListId);
}
