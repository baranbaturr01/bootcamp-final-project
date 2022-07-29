package services;

import repository.CustomerPolicyRepository;

public class CustomerPolicyService {
   static CustomerPolicyRepository customerPolicyRepository = new CustomerPolicyRepository();

    public static String getCustomerPolicyByIds(int firstId, int secondId) {
        return customerPolicyRepository.getCustomerPoliciesByIds(firstId, secondId);
    }
}
