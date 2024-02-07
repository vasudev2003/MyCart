package test;

import org.junit.Test;

import main.java.entities.User;
import main.java.repositiories.UserRepository;
import main.java.services.UserService;
import java.sql.Connection;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void testAddUser() {
        Connection connection = null;

        UserRepository userRepository = new UserRepository(connection);
        UserService userService = new UserService(userRepository);
        User user = new User("1", "John");

   
        userService.getUserById(user.getId());
        User retrievedUser = userService.getUserById("1");

        assertEquals(user, retrievedUser);
    }
    
}
