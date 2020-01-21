package SpringShop.repository;
import SpringShop.model.Product;
import SpringShop.model.ProductsCategory;
import SpringShop.repository.ProductRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepoTestSuite {

    @Autowired
    private ProductRepo productRepo;
    private static final String NAME = "TestName";
    private static final ProductsCategory CATEGORY = ProductsCategory.AGD;
    private static final String DESCRIPTION = "Test descscription";
    private static final Integer QUANTITY = 42;
    private static final BigDecimal PRICE = new BigDecimal(599.99);

    @Test
    public void testProductDaoTesting() {
        //Given
        Product product = new Product();
        product.setProductName(NAME);
        product.setProductCategory(ProductsCategory.RTV);
        product.setProductDescription(DESCRIPTION);
        product.setProductInStock(QUANTITY);
        product.setProductPrice(PRICE);
        productRepo.save(product);
        Integer testResult = product.getProductId();
        //When
        List<Product> productsList = productRepo.findByProductId(testResult);
        //Then
        Assert.assertEquals(1, productsList.size());
        //CleanUp
        int id = productsList.get(0).getProductId();
        productRepo.deleteById(id);
    }
}