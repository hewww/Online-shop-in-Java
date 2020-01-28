package SpringShop.repository;

import SpringShop.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepoTestSuite {
    @Autowired
    private UserRepo userRepo;
    private static final String USERNAME = "TestUser";
    private static final String PASSWORD = "testPassword";

    @Autowired
    private ProductRepo productRepo;
    private static final String NAME = "TestName";
    private static final ProductsCategory CATEGORY = ProductsCategory.AGD;
    private static final String DESCRIPTION = "Test descscription";
    private static final Integer QUANTITY = 42;
    private static final BigDecimal PRICE = new BigDecimal(599.99);

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ProductToCartRepo productToCartRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void testOrderRepo() {

        //Given
        User user = new User();
        user.setUsername("TestUsername");
        user.setPassword("testpassword");


        Address address = new Address();
        address.setCity("Warsaw");
        address.setCountry("Poland");
        address.setStreet("Testowa 9/11");
        address.setZipcode("00-000");
        address.setUser(user);

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
        productToCart2.setQuantity(8);

        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(987.99));
        cart.getProductsList().add(productToCart);
        cart.getProductsList().add(productToCart2);

        Order order = new Order();
        order.setAddress(address);
        order.setCart(cart);
        order.setUser(user);
        order.setTotalPrice(new BigDecimal(999.99));


        userRepo.save(user);
        addressRepo.save(address);
        productRepo.save(product);
        productToCartRepo.save(productToCart);
        productToCartRepo.save(productToCart2);
        cartRepo.save(cart);
        orderRepo.save(order);

        Integer id = user.getUserId();
        List<Order> cartLists = orderRepo.findByUser(user);

        Assert.assertEquals(1,cartLists.size());

        //Clean Up
        orderRepo.deleteById(cartLists.get(0).getOrderId());
        cartRepo.deleteById(cartLists.get(0).getCart().getCartId());
        productToCartRepo.deleteById(productToCart.getProductToCartId());
        productToCartRepo.deleteById(productToCart2.getProductToCartId());
        productRepo.deleteById(product.getProductId());
        addressRepo.deleteById(cartLists.get(0).getAddress().getAddressId());
        userRepo.deleteById(cartLists.get(0).getUser().getUserId());




    }
}
