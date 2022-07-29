package repository;

import entity.Policy;
import util.HibernateUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class PolicyRepository  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public boolean addPolicy(int id,String name, String status) throws SQLException {
        session.beginTransaction();
        Policy policy = new Policy(id,name, status);
        session.persist(policy);
        session.getTransaction().commit();
        return true;
    }

    public List<String> getPolicyNameAndTotalPayment() throws SQLException {

        session.beginTransaction();
        //PaymentRepository de createQuery kullandım HQL ile burada ise direkt Sql kullandım bunun içinde nativequery kullandım.Çeşitlilik amacıyla yazılmıştır
        String Sql = "Select distinct policy.name as policy_name,sum(customer_policy.insurance_amount) as total_payment from payment inner join customer_policy on payment.customer_policy_id=customer_policy.id inner join policy on policy.id=customer_policy.policy_id inner join agency on customer_policy.agency_id=agency.id group by policy.name";

        Query query = session.createNativeQuery(Sql);
        List<Object[]> list = query.getResultList();
        List<String> policyNameAndTotalPayment = new ArrayList<>();
        for (Object[] objects : list) {
            String policyName = objects[0].toString();
            String totalPayment = objects[1].toString();
            policyNameAndTotalPayment.add(policyName + "," + totalPayment);
        }
        session.getTransaction().commit();
        return policyNameAndTotalPayment;

    }

    public Policy getPolicy(int id) throws SQLException {
        session.beginTransaction();
        Query query = session.createQuery("from Policy policy where policy.id=:id", Policy.class);
        query.setParameter("id", id);
        Policy policy = (Policy) query.getSingleResult();
        session.getTransaction().commit();
        return policy;
    }

    public List<Policy> getAllPolicies() throws SQLException {
        session.beginTransaction();
        Query query = session.createQuery("from Policy policy", Policy.class);
        List<Policy> policies = query.getResultList();
        session.getTransaction().commit();
        return policies;
    }

}
