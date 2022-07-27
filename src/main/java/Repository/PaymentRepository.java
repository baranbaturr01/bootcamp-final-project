package Repository;

import Entity.Payment;
import Util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class PaymentRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<String> getAllPayments() throws SQLException {

        session.beginTransaction();
        TypedQuery<Payment> query = session.createQuery("from Payment payment  inner join payment.customer_policy cp inner join cp.customer c  inner join cp.agency a ", Payment.class);
        List<Payment> payments = query.getResultList();
        List<String> paymentsString = new ArrayList<>();
        for (Payment payment : payments) {
            String paymentString = payment.getCustomerPolicy().getCustomer().getName() + " " + payment.getCustomerPolicy().getAgency().getName() + " " + payment.getCustomerPolicy().getInsurance_amount() + " " + payment.getPayment_date();
            paymentsString.add(paymentString);
        }
        session.getTransaction().commit();
        return paymentsString;
    }
}
