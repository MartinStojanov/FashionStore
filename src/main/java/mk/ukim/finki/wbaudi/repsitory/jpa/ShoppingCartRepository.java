package mk.ukim.finki.wbaudi.repsitory.jpa;

import mk.ukim.finki.wbaudi.model.ShoppingCart;
import mk.ukim.finki.wbaudi.model.User;
import mk.ukim.finki.wbaudi.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
