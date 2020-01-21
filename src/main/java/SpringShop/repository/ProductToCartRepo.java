package SpringShop.repository;

import SpringShop.model.Product;
import SpringShop.model.ProductToCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductToCartRepo extends JpaRepository<ProductToCart,Integer> {
    List<ProductToCart> findByProduct(Product product);
}
