package SpringShop.Controller;

import SpringShop.Service.DbService;
import SpringShop.model.Product;
import SpringShop.model.ProductsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public List getProduct(@RequestParam Integer Id) {
        return service.getProduct(Id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Integer id) {
        service.deleteProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "updateProduct", consumes = APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

}
