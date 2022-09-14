package pl.coderslab.bookapispringboot.services;

import pl.coderslab.bookapispringboot.models.User;

public interface UserService {

    User findByUserName(String username);
    void saveUser(User user);
    void saveAdmin(User user);
}
