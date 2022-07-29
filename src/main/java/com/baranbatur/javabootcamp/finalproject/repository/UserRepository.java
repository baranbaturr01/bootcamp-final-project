package com.baranbatur.javabootcamp.finalproject.repository;

import com.baranbatur.javabootcamp.finalproject.entity.User;
import com.baranbatur.javabootcamp.finalproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<User> getAllUsers() throws SQLException {

        session.beginTransaction();
        List<User> users = new ArrayList<>();

        Query query = session.createQuery("from User", User.class);
        users = query.list();
        session.getTransaction().commit();

        return users;

    }

    public boolean addUser(int id, String name, String surname, String email, String pass) throws SQLException {

        session.beginTransaction();
        User user = new User(id, name, surname, email, pass);
        session.persist(user);
        session.getTransaction().commit();


        return true;
    }

    public User getUserByEmail(String email) {
        session.beginTransaction();
        Query<User> query = session.createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.getTransaction().commit();
        return user;

    }

}
