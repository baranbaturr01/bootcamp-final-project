package com.baranbatur.finalproject.services;

import com.baranbatur.finalproject.repository.PaymentRepository;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {

    static PaymentRepository paymentRepository = new PaymentRepository();

    /**
     * @return List<Payment>
     * @throws SQLException
     */
    public static List<String> getAllPayments() throws SQLException {

        return paymentRepository.getAllPayments();
    }
}
