package pl.coderslab.bookapispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bookapispringboot.models.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
