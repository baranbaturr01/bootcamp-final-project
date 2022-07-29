package com.baranbatur.javabootcamp.finalproject.services;

import com.baranbatur.javabootcamp.finalproject.repository.CustomerPolicyRepository;

public class CustomerPolicyService {
   static CustomerPolicyRepository customerPolicyRepository = new CustomerPolicyRepository();

    public static String getCustomerPolicyByIds(int firstId, int secondId) {
        return customerPolicyRepository.getCustomerPoliciesByIds(firstId, secondId);
    }
}
