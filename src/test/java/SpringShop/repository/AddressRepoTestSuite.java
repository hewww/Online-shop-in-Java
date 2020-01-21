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
        user.setUsername("TestUsername");
        user.setPassword("testpassword");

        Address address = new Address();
        address.setCity("Warsaw");
        address.setCountry("Poland");
        address.setStreet("Testowa 9/11");
        address.setZipcode("00-000");
        address.setUser(user);
        userRepo.save(user);
        addressRepo.save(address);
        //When
        List<Address> adress = addressRepo.findByUser(user);
        //Then
        Assert.assertEquals(1, adress.size());
        //CleanUp
        Integer id = adress.get(0).getAddressId();
        Integer userId = user.getUserId();
        addressRepo.deleteById(id);
        userRepo.deleteById(userId);
    }

}
