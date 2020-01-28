package SpringShop.repository;

import SpringShop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CartRepo extends JpaRepository<Cart,Integer> {
    List<Cart> findByCartId(Integer cartId);
}
