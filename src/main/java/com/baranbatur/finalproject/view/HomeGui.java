package com.baranbatur.finalproject.view;

import com.baranbatur.finalproject.helper.Config;
import com.baranbatur.finalproject.helper.Helper;
import com.baranbatur.finalproject.entity.User;
import com.baranbatur.finalproject.services.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class HomeGui extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton bn_logout;
    private JScrollPane scr_user_list;
    private JTable tbl_user_list;
    private JTabbedPane tabbedPane1;
    private JButton list_btn;

    private DefaultTableModel mdl_user_list;
    private Object[] columnNames = {"ID", "Name", "Surname", "Email", "Type"};

    public HomeGui(String name) throws IOException {
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.setLocation("x", getSize());
        int y = Helper.setLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.APP_NAME);
        setVisible(true);
        lbl_welcome.setText("Welcome, " + name);
        //ModelUserList
        mdl_user_list = new DefaultTableModel(columnNames, 0);
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        try {
            for (User obj : UserService.getAllUsers()) {
                System.out.println(obj);
                mdl_user_list.addRow(new Object[]{obj.getId(), obj.getName(), obj.getSurname(), obj.getEmail()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        list_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //insert icon
                    ListOfFinancelData listOfFinancelData = new ListOfFinancelData();
                    listOfFinancelData.tableOfPayments();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        new HomeGui("");

    }
}
