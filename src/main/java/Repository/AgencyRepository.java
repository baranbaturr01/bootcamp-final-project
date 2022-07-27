package Repository;

import Entity.Agency;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AgencyRepository {

    Transaction transaction = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /**
     * @param agency
     * @return boolean
     */
    public boolean save(Agency agency) {

        try {
            session.save(agency);
            transaction.commit();
            //kill transaction
            transaction = null;
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }

    public void delete(Agency agency) {

        //delete a data from database
        try {
            session.createNativeQuery("DELETE FROM public.agency WHERE id = :id").setParameter("id", agency.getId()).executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    public boolean update(Agency agency) {

        try {
            session.createQuery("UPDATE Agency SET name = :name, address = :address, email = :email WHERE id = :id").setParameter("name", agency.getName()).setParameter("address", agency.getAddress()).setParameter("email", agency.getEmail()).setParameter("id", agency.getId()).executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }

}
