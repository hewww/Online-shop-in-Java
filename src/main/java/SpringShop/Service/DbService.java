package SpringShop.Service;

import SpringShop.model.Address;
import SpringShop.model.Order;
import SpringShop.model.Product;
import SpringShop.model.User;
import SpringShop.repository.AddressRepo;
import SpringShop.repository.OrderRepo;
import SpringShop.repository.ProductRepo;
import SpringShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DbService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private OrderRepo orderRepo;

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public void addAddress(final Address address) {
        addressRepo.save(address);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(final Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProduct(final Integer productId) {
        return productRepo.findByProductId(productId);
    }

    public void deleteProduct(final Integer productId) {
        productRepo.deleteById(productId);
    }



    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public List<User> getUser(final Integer userId) {
        return userRepo.findByUserId(userId);
    }

    public void addUser(final User user) {
        userRepo.save(user);
    }

    public void deleteUser(final Integer userId) {
        userRepo.deleteById(userId);
    }


    public List<Order> getAllOrders() { return orderRepo.findAll();}
    public Order addOrder(final Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(final Integer orderId) {
        orderRepo.deleteById(orderId);
    }


    public List<Order> getOrder(Integer orderId) {
        return orderRepo.findByOrderId(orderId);
    }

    public void deleteAddress(final Integer addressId) {
        addressRepo.deleteById(addressId);
    }


}
