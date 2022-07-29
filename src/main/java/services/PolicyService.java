package services;

import entity.Policy;
import repository.PolicyRepository;

import java.sql.SQLException;
import java.util.List;

public class PolicyService {

    static PolicyRepository policyRepository = new PolicyRepository();

    public static boolean addPolicy(int id,String name, String status) throws SQLException {
        return policyRepository.addPolicy(id,name, status);
    }

    public static Policy getPolicy(int id) throws SQLException {
        return policyRepository.getPolicy(id);
    }

    public static List<String> getPolicyNameAndTotalPayment() throws SQLException {
        return policyRepository.getPolicyNameAndTotalPayment();
    }

    public static List<Policy> getAllPolicies() throws SQLException {
        return policyRepository.getAllPolicies();
    }


}
