package com.baranbatur.finalproject.services;

import com.baranbatur.finalproject.entity.User;
import com.baranbatur.finalproject.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    static UserRepository userRepository = new UserRepository();


    public static List<User> getAllUsers() throws SQLException {

        return userRepository.getAllUsers();
    }

    public static boolean addUser(int id,String name, String surname, String email, String pass) throws SQLException {

        return userRepository.addUser(id,name, surname, email, pass);
    }

    public static User getUserByEmail(String email) {
        System.out.println("getUserByEmail" + email);
        return userRepository.getUserByEmail(email);
    }

}
