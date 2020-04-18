package SpringShop.repository;

import SpringShop.model.Product;
import SpringShop.model.ProductsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Locale;
@Transactional
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    void deleteById(Integer productId);

    List<Product> findByProductId(Integer productId);

    List<Product> findAllByProductCategory(ProductsCategory productsCategory);
    List<Product> findByProductName(String productTitle);
    List<Product> findByProductCategory(ProductsCategory productsCategory);
}
