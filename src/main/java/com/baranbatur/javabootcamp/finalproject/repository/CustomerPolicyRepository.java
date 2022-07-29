package com.baranbatur.javabootcamp.finalproject.repository;

import com.baranbatur.javabootcamp.finalproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerPolicyRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public String getCustomerPoliciesByIds(int firstId, int secondId) {

        //2 querys to get the customer policies by ids and sum insurance_amount and policy_name
        Query firstIdQuery = session.createQuery("select sum(insurance_amount) ,policy.name from CustomerPolicy where policy.id = :firstId group by policy.name");
        firstIdQuery.setParameter("firstId", firstId);
        Query secondIdQuery = session.createQuery("select sum(insurance_amount),policy.name  from CustomerPolicy where policy.id = :secondId group by policy.name");
        secondIdQuery.setParameter("secondId", secondId);

        List<Object[]> firstIdResult = firstIdQuery.list();
        List<Object[]> secondIdResult = secondIdQuery.list();

        String result = "";

        for (Object[] objects : firstIdResult) {
            result += objects[1] + "," + objects[0] + ";";
        }
        for (Object[] objects : secondIdResult) {
            result += objects[1] + "," + objects[0] + ";";
        }

        return result;
    }


}
