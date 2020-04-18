package SpringShop.repository;

import SpringShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Integer userId);

    List<User> findByUsername(String username);
    List<User> findByUserId(Integer userId);
}
