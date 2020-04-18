package SpringShop.repository;

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
public class UserRepoTestSuite {

    @Autowired
    private UserRepo userRepo;
    private static final String USERNAME = "TestUser";
    private static final String PASSWORD = "testPassword";
    private static final String MAIL = "mail@test.pl";


    @Test
    public void testUserRepoTesting() {
        //Given
        User user = new User();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        user.setMail(MAIL);
        userRepo.save(user);
        String testResult = user.getUsername();
        //When
        List<User> usersList = userRepo.findByUsername(testResult);
        //Then
        Assert.assertEquals(1, usersList.size());
        //CleanUp
        Integer id = usersList. get(0).getUserId();
        userRepo.deleteById(id);
    }
}