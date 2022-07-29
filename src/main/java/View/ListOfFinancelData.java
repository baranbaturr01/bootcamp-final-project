package View;

import Entity.Policy;
import Helper.Config;
import Helper.Helper;
import Services.CustomerPolicyService;
import Services.PaymentService;
import Services.PolicyService;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ListOfFinancelData extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTable tbl_payments;
    private JButton reports_btn;
    private JButton barChartButton;
    private JButton lineChartButton;
    private JButton pieChartButton;
    private JTable tbl_policy;
    private JPanel customer_policy;
    private JButton btnLineChartPolicy;
    private JButton btnBarChartPolicy;
    private JButton btnPieChartPolicy;
    private JButton btnReportsPolicy;
    private JComboBox first_policy_combobox;
    private JPanel comboxes;
    private JComboBox second_policy_combobox;
    private JButton compareButton;
    private JTable tableforcompare;
    private JButton compareShowBarButton;

    public ListOfFinancelData() throws SQLException {

        add(panel1);
        setSize(1000, 500);
        int x = Helper.setLocation("x", getSize());
        int y = Helper.setLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Config.APP_NAME);
        setVisible(true);
        setAllComboboxes();

        tabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //firstly click on the tabbed pane, the table is empty, so we need to fill it with data
                try {
                    tableOfPayments();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (tabbedPane1.getSelectedIndex() == 1) {
                    try {
                        tableOfPolicies();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        reports_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.saveReportsForExcel(tbl_payments, "Payments");
            }
        });
        barChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createBarChart("Payment Statistics", "Agency", "Amount", tbl_payments, 2, "Payment Statistics");
            }
        });

        lineChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createlineChart("Payment Statistics", "Agency", "Amount", tbl_payments, "Payment", 2);
            }
        });
        pieChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createPieChart("Payment Statistics", tbl_payments, 1);
            }
        });

        btnLineChartPolicy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createlineChart("Policy Statistics", "Policy Name", "Total Amount", tbl_policy, "Policy Statistics", 1);
            }
        });
        btnBarChartPolicy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createBarChart("Policy Statistics", "Policy Name", "Total Amount", tbl_policy, 1, "Policy Statistics");
            }
        });
        btnPieChartPolicy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.createPieChart("Policy Statistics", tbl_policy, 0);
            }
        });
        btnReportsPolicy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.saveReportsForExcel(tbl_policy, "Policies");
            }
        });
        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get first and second policy id from comboboxes
                String firstPolicy = Objects.requireNonNull(first_policy_combobox.getSelectedItem()).toString();
                String secondPolicy = Objects.requireNonNull(second_policy_combobox.getSelectedItem()).toString();
                int firstPolicyId = 0;
                int secondPolicyId = 0;

                if (firstPolicy.equals("Select Policy")) {
                    JOptionPane.showMessageDialog(null, "Please select a policy");
                    return;
                }
                if (secondPolicy.equals("Select Policy")) {
                    JOptionPane.showMessageDialog(null, "Please select a policy");
                    return;
                }
                try {
                    for (Policy policy : PolicyService.getAllPolicies()) {
                        if (policy.getName().equals(firstPolicy)) {
                            firstPolicyId = policy.getId();
                        }
                        if (policy.getName().equals(secondPolicy)) {
                            if (secondPolicy.equals("Select Policy")) {
                                JOptionPane.showMessageDialog(null, "Please select a policy");
                                return;
                            }
                            if (firstPolicy.equals(secondPolicy)) {
                                JOptionPane.showMessageDialog(null, "Please select different policies");
                                return;
                            }
                            secondPolicyId = policy.getId();
                        }
                    }

//                    tableforcompare.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Policy Name", "Total Amount"}));
                    DefaultTableModel model = Helper.createTableModel(new Object[]{"Policy Name", "Total Amount"}, tableforcompare);
                    String policies = CustomerPolicyService.getCustomerPolicyByIds(firstPolicyId, secondPolicyId);

                    System.out.println(policies);
                    String[] policiesArray = policies.split(";");
                    for (String policy : policiesArray) {
                        String[] policyArray = policy.split(",");
                        String policyName = policyArray[0];
                        String policyAmount = policyArray[1];

                        model.addRow(new Object[]{policyName, policyAmount});


                    }
                    tableforcompare.setModel(model);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(firstPolicyId);
            }
        });
        compareShowBarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableforcompare.getRowCount() == 0) {
                    //disabled
                    JOptionPane.showMessageDialog(null, "Please click on the compare show table button first");
                    return;
                }
                Helper.createBarChart("Policy Statistics", "Policy Name", "Total Amount", tableforcompare, 1, "Policy Statistics");

            }
        });
    }

    public void tableOfPayments() throws SQLException {
        DefaultTableModel model = Helper.createTableModel(new Object[]{"Customer Name", "Agency Name", "Amount", "Payment Date"}, tbl_payments);

        List<String> payments = PaymentService.getAllPayments();

        try {
            for (String data : payments) {
                model.addRow(new Object[]{data.split(" ")[0], data.split(" ")[1], data.split(" ")[2], data.split(" ")[3]});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAllComboboxes() throws SQLException {
        //set the first policy combobox
        first_policy_combobox.removeAllItems();
        first_policy_combobox.addItem("Select Policy");
        for (Policy policy : PolicyService.getAllPolicies()) {
            first_policy_combobox.addItem(policy.getName());
        }
        //set the second policy combobox
        second_policy_combobox.removeAllItems();
        second_policy_combobox.addItem("Select Policy");
        for (Policy policy : PolicyService.getAllPolicies()) {
            second_policy_combobox.addItem(policy.getName());
        }
    }

    private void tableOfPolicies() throws SQLException {
        DefaultTableModel model = Helper.createTableModel(new Object[]{"Policy Name", "Total Payment"}, tbl_policy);
        List<String> policies = PolicyService.getPolicyNameAndTotalPayment();
        try {
            for (String data : policies) {

                model.addRow(new Object[]{data.split(",")[0], data.split(",")[1]});

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}