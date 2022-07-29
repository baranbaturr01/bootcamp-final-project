package com.baranbatur.javabootcamp.finalproject.view;

import com.baranbatur.javabootcamp.finalproject.helper.Config;
import com.baranbatur.javabootcamp.finalproject.helper.Helper;
import com.baranbatur.javabootcamp.finalproject.entity.User;
import com.baranbatur.javabootcamp.finalproject.services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGui extends JFrame {
    private JPanel wrapper;
    private JPanel top;
    private JPanel bottom;
    private JLabel lbl_welcome;
    private JTextField txt_email;
    private JPasswordField txt_pass;
    private JButton btn_login;
    private JButton kayıtOlButton;

    public LoginGui() {
        add(wrapper);
        setSize(500, 300);
        int x = Helper.setLocation("x", getSize());
        int y = Helper.setLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.APP_NAME);
        setVisible(true);
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String email = txt_email.getText();
                    String pass = String.valueOf(txt_pass.getPassword());

                    User user = UserService.getUserByEmail(email);
                    if (user != null) {
                        System.out.println(user.getPass());
                        if (user.getPass().trim().equals(pass.trim())) {
                            HomeGui homeGui = new HomeGui(user.getName());
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong password!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User not found!");
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        kayıtOlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterGui registerGui = new RegisterGui();
                dispose();
            }
        });
    }

}
