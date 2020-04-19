package SpringShop.Controller;
import SpringShop.Service.DbService;
import SpringShop.model.Address;
import SpringShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.Entity;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addOrder",consumes = APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody Order order) {
        service.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public void getOrder(@RequestParam Integer orderId) {
        service.getOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Integer orderId) {
        service.deleteOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder",consumes = APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody Order order) {
        service.addOrder(order);
    }
}
