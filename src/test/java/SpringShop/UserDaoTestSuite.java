package SpringShop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite extends SpringBeanAutowiringSupport {
    @Autowired
    private UserDao userDao;
    private static final String USERNAME = "TestUser";
    private static final String EMAIL = "test@test.com";
    private static final String PHONE = "600600600";
    private static final String ADDRESS = "Address 41/5";
    private static final String CITY_REGION = "Tested Region";

    @Test
    public void testUsersDaoTesting() {
        //Given
        User user = new User(USERNAME,EMAIL,PHONE,ADDRESS,CITY_REGION);
        userDao.save(user);
        String testResult = user.getUsername();
        //When
        List<User> usersList = userDao.findByUsername(testResult);
        //Then
        Assert.assertEquals(1, usersList.size());
        //CleanUp
        int id = usersList.get(0).getUserId();
        userDao.deleteById(id);
    }
}