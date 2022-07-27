package Services;

import Entity.User;
import Repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    static UserRepository userRepository = new UserRepository();


    public static List<User> getAllUsers() throws SQLException {

        return userRepository.getAllUsers();
    }

    public static boolean addUser(String name, String surname, String email, String pass) throws SQLException {

        return userRepository.addUser(name, surname, email, pass);
    }

    public static User getUserByEmail(String email) {
        System.out.println("getUserByEmail" + email);
        return userRepository.getUserByEmail(email);
    }

}
