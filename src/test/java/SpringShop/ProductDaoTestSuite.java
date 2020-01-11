package SpringShop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    private static final String TITLE = "TestTitle";
    private static final String DESCRIPTION = "Test descscription";
    private static final Integer QUANTITY = 42;
    private static final BigDecimal PRICE = new BigDecimal(599.99);

    @Test
    public void testProductDaoTesting() {
        //Given
        Product product = new Product(TITLE,DESCRIPTION,QUANTITY,PRICE);
        productDao.save(product);
        String testResult = product.getProductTitle();
        //When
        List<Product> productsList = productDao.findByProductTitle(testResult);
        //Then
        Assert.assertEquals(1,productsList.size());
        //CleanUp
        int id = productsList.get(0).getProductId();
        productDao.deleteById(id);
    }
}