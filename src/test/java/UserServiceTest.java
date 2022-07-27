import Entity.User;
import Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class UserServiceTest {

    @Test
    public void get_all_user_test() throws SQLException {
        List<User> users = UserService.getAllUsers();
        Assertions.assertEquals(1, users.size());
        //Assertions.assertEquals("admin", users.get(0).getUsername());
        Assertions.assertTrue(users instanceof List);

    }

    @Test
    public void get_user_by_b_email_test() throws SQLException {

//        User user = UserService.getUserByEmail("b");
//        Assertions.assertEquals("b", user.getEmail().trim());
//        Assertions.assertEquals(user instanceof User, true);
    }
}
