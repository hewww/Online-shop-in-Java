package SpringShop.repository;

import SpringShop.model.Order;
import SpringShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findByUser(User user);
}
