package SpringShop.repository;

import SpringShop.model.Address;
import SpringShop.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepoTestSuite {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testAddressRepoTesting() {
        //Given
        User user = new User();
        user.setMail("sdasdasdasd");
        user.setUsername("testtews");
        user.setPassword("passwords");

        Address address = new Address();
        address.setCity("Warsaw");
        address.setCountry("Poland");
        address.setStreet("Testowa 9/11");
        address.setZipcode("00-000");
        address.setUser(user);
        userRepo.save(user);
        addressRepo.save(address);
        //When
        Integer id = addressRepo.findAll().get(0).getAddressId();
        List<Address> adress = addressRepo.findByAddressId(id);
        Integer userId = userRepo.findAll().get(0).getUserId();

        //Then
        Assert.assertEquals(1, adress.size());
        //CleanUp
        addressRepo.deleteById(id);
        userRepo.deleteById(userId);
    }
}
