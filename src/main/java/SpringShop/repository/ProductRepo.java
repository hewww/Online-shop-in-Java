package SpringShop.repository;

import SpringShop.model.Product;
import SpringShop.model.ProductsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByProductId(Integer productId);
    List<Product> findByProductName(String productTitle);
    List<Product> findByProductCategory(ProductsCategory productsCategory);
}
