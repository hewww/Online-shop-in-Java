package SpringShop.repository;

import SpringShop.model.Cart;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepoTestSuite {

    @Autowired
    private ProductRepo productRepo;
    private static final String NAME = "TestName";
    private static final ProductsCategory CATEGORY = ProductsCategory.AGD;
    private static final String DESCRIPTION = "Test descscription";
    private static final Integer QUANTITY = 42;
    private static final BigDecimal PRICE = new BigDecimal(599.99);

    @Autowired
    private ProductToCartRepo productToCartRepo;

    @Autowired
    private CartRepo cartRepo;

    @Test
    public void testCartRepo() {
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

        ProductToCart productToCart2 = new ProductToCart();
        productToCart2.setProduct(product);
        productToCart2.setQuantity(6);



        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(500));
        cart.getProductsList().add(productToCart);
        cart.getProductsList().add(productToCart2);

        productRepo.save(product);
        productToCartRepo.save(productToCart);
        productToCartRepo.save(productToCart2);
        cartRepo.save(cart);

        //When
        Integer cartId = cart.getCartId();
        Integer pId = product.getProductId();
        Integer ptcId = productToCart.getProductToCartId();
        List<Cart> result = cartRepo.findByCartId(cartId);

        //Then
        Assert.assertEquals(1,result.size());

        //CleanUp
        cartRepo.deleteById(cartId);
        productToCartRepo.deleteById(ptcId);
        productRepo.deleteById(pId);


    }
}
