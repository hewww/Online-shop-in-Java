package SpringShop.repository;

import SpringShop.model.Product;
import SpringShop.model.ProductToCart;
import SpringShop.model.ProductsCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductToCartRepoTestSuite {

    @Autowired
    private ProductToCartRepo productToCartRepo;

    @Autowired
    private ProductRepo productRepo;
    private static final String NAME = "TestName";
    private static final ProductsCategory CATEGORY = ProductsCategory.AGD;
    private static final String DESCRIPTION = "Test descscription";
    private static final Integer QUANTITY = 42;
    private static final BigDecimal PRICE = new BigDecimal(599.99);



    @Test
    public void testProductToCartRepo() {
        //Given
        Product product = new Product();
        product.setProductName(NAME);
        product.setProductCategory(CATEGORY);
        product.setProductDescription(DESCRIPTION);
        product.setProductInStock(QUANTITY);
        product.setProductPrice(PRICE);

        ProductToCart productToCart = new ProductToCart();
        productToCart.setProduct(product);
        productToCart.setQuantity(5);

        productRepo.save(product);
        productToCartRepo.save(productToCart);

        //When
        List<ProductToCart> list = productToCartRepo.findByProduct(product);

        //Then
        Assert.assertEquals(1, list.size());

        //CleanUp
        Integer ptcId = list.get(0).getProductToCartId();
        Integer pId = product.getProductId();
        productToCartRepo.deleteById(ptcId);
        productRepo.deleteById(pId);
    }





}
