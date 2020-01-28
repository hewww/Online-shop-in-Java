package SpringShop.repository;

import SpringShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);
}
