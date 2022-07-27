import Services.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceTest {
    @Test
    public void getAllPayments() throws SQLException {
        //check is String list is returned
        Assertions.assertTrue(PaymentService.getAllPayments() != null);
        System.out.println("getAllPayments() test passed");
        //check if list is not empty
        Assertions.assertFalse(PaymentService.getAllPayments().isEmpty());

        //check if list is not null
        Assertions.assertNotNull(PaymentService.getAllPayments());

    }
}
