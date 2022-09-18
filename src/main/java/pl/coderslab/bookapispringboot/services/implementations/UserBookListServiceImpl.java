package pl.coderslab.bookapispringboot.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapispringboot.models.UserBookList;
import pl.coderslab.bookapispringboot.repositories.UserBookListRepository;
import pl.coderslab.bookapispringboot.services.UserBookListService;

import java.util.List;

@Service
public class UserBookListServiceImpl implements UserBookListService {

    public UserBookListServiceImpl(UserBookListRepository userBookListRepository) {
        this.userBookListRepository = userBookListRepository;
    }

    private final UserBookListRepository userBookListRepository;


    @Override
    public List<UserBookList> findUserBookListByUserId(Long userId) {
        return userBookListRepository.findAllByUserId(userId);
    }

    @Override
    public void saveUserBookList(UserBookList userBookList) {
        userBookListRepository.save(userBookList);
    }

    @Override
    public void deleteUserBookListById(Long userBookListId) {
        userBookListRepository.deleteById(userBookListId);
    }

    @Override
    public UserBookList findByUserBookListId(Long userBookListId) {
        return userBookListRepository.findById(userBookListId).get();
    }
}
