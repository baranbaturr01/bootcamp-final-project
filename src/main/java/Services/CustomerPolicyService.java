package Services;

import Entity.CustomerPolicy;
import Repository.CustomerPolicyRepository;

import java.util.List;

public class CustomerPolicyService {
   static CustomerPolicyRepository customerPolicyRepository = new CustomerPolicyRepository();

    public static String getCustomerPolicyByIds(int firstId, int secondId) {
        return customerPolicyRepository.getCustomerPoliciesByIds(firstId, secondId);
    }
}
