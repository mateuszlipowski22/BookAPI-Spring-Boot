package pl.coderslab.bookapispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.bookapispringboot.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
