package pl.coderslab.bookapispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.bookapispringboot.models.Role;
import pl.coderslab.bookapispringboot.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_role WHERE user_id = ?1", nativeQuery = true)
    void deleteUserRole(Long id);

    List<User> findAllByRolesContaining(Role role);

}


