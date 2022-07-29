package com.baranbatur.finalproject.view;

import com.baranbatur.finalproject.entity.User;
import com.baranbatur.finalproject.helper.Helper;
import com.baranbatur.finalproject.services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterGui extends JFrame {
    private JPanel wrapper;
    private JPanel top;
    private JPanel bottom;
    private JLabel lbl_register;
    private JTextField first_name_txt_fld;
    private JTextField last_name_txt_fld;
    private JTextField email_txt_fld;
    private JPasswordField password_txt_fld;
    private JButton register_btn;
    private JButton backButton;

    RegisterGui() {
        add(wrapper);
        setSize(650, 500);
        int x = Helper.setLocation("x", getSize());
        int y = Helper.setLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first_name = first_name_txt_fld.getText();
                String last_name = last_name_txt_fld.getText();
                String email = email_txt_fld.getText();
                String password = String.valueOf(password_txt_fld.getPassword());
                try {
                    User user=UserService.getUserByEmail(email);
                    UserService.addUser(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPass());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "User added successfully!");
                LoginGui loginGui = new LoginGui();
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGui loginGui = new LoginGui();
                dispose();
            }
        });
    }
}
