import com.baranbatur.javabootcamp.finalproject.entity.Policy;
import com.baranbatur.javabootcamp.finalproject.services.PolicyService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PolicyServiceTest {

    @Test
    public void add_policy_test() {
        try {
            Policy policy=new Policy();
            policy.setName("test");
            policy.setStatus("test");
            assertTrue(PolicyService.addPolicy(policy.getId(),policy.getName(),policy.getStatus()));
            System.out.println("add_policy_test passed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public Policy get_policy_1_test() {
        try {
            Policy policy = PolicyService.getPolicy(1);
            assertInstanceOf(Policy.class, policy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void get_policy_name_and_total_payment_test() {
        try {
            List<String> list = PolicyService.getPolicyNameAndTotalPayment();
            assertTrue(list != null);
            assertTrue(list.size() > 0);
            //instance of list
            assertInstanceOf(List.class, list);
            System.out.println("getPolicyNameAndTotalPayment() test passed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
