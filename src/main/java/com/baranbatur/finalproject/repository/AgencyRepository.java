package com.baranbatur.finalproject.repository;

import com.baranbatur.finalproject.entity.Agency;
import com.baranbatur.finalproject.util.HibernateUtil;
import org.hibernate.Session;

public class AgencyRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * @param agency
     * @return boolean
     */
    public boolean save(Agency agency) {
        session.beginTransaction();
        try {
            session.save(agency);
            session.getTransaction().commit();
            //kill transaction
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }

    }

    public boolean delete(Agency agency) {

        session.beginTransaction();
        //delete a data from database
        try {
            session.delete(agency);
            session.getTransaction().commit();
            //kill transaction
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Agency agency) {
        session.beginTransaction();
        //update a data from database
        try {
            session.update(agency);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
