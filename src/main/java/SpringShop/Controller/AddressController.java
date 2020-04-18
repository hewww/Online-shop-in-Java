package SpringShop.Controller;

import SpringShop.Service.DbService;
import SpringShop.model.Address;
import SpringShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/address")
public class AddressController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getAllAddress")
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "getAddress")
//    public List<Address> getAddress(@RequestParam Integer userId) {
//        return service.getAddress(userId);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "addAddress", consumes = APPLICATION_JSON_VALUE)
    public void addAddress(@RequestBody Address address){
        service.addAddress(address);
    }
}
