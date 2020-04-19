package SpringShop.Controller;

        import SpringShop.Service.DbService;
        import SpringShop.model.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;
        import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public List getUser(@RequestParam Integer userId) {
        return service.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

    @RequestMapping(method = RequestMethod.GET,value = "getUsers")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Integer userId) {
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser", consumes = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {
        service.addUser(user);
    }
}
