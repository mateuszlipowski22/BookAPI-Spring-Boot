package pl.coderslab.bookapispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.bookapispringboot.models.UserBookList;

import java.util.List;

@Repository
public interface UserBookListRepository extends JpaRepository<UserBookList,Long> {

    List<UserBookList> findAllByUserId(Long id);
}
