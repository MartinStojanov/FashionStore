package mk.ukim.finki.wbaudi.repsitory.jpa;

import mk.ukim.finki.wbaudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
Optional<User> findByUsernameAndPassword(String username, String password);
Optional<User> findByUsername(String username);
}
