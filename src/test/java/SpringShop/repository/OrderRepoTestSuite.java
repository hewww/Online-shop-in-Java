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
    private OrderRepo orderRepo;

    @Test
    public void testOrderRepo() {

        //Given

        Address address = new Address();
        address.setCity("Warsaw");
        address.setCountry("Poland");
        address.setStreet("Testowa 9/11");
        address.setZipcode("00-000");

        User user = new User();
        user.setUsername("TestUsername");
        user.setPassword("testpassword");
        user.setMail("test@test.pl");
        user.setAddress(address);


        Product product = new Product();
        product.setProductName(NAME);
        product.setProductCategory(CATEGORY);
        product.setProductDescription(DESCRIPTION);
        product.setProductInStock(QUANTITY);
        product.setProductPrice(PRICE);



        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setUser(user);
        order.setProduct(product);
        order.setAmmount(5);
        order.setTotalPrice(new BigDecimal(999.99));

        addressRepo.save(address);
        userRepo.save(user);
        productRepo.save(product);
        orderRepo.save(order);

        Integer orderId = order.getOrderId();
        List<Order> orderList = orderRepo.findByOrderId(orderId);

        Assert.assertEquals(1,orderList.size());

        //Clean Up
        orderRepo.deleteById(orderId);
        productRepo.deleteById(product.getProductId());
        userRepo.deleteById(user.getUserId());
        addressRepo.deleteById(address.getAddressId());
    }
}
