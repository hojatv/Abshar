package com.abshar.educational.system.persistence;

import com.abshar.educational.system.model.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hovaheb on 10/19/2016.
 */
@Component
public class DataDaoImpl implements DataDao {
    /**
     * Session factory.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Sets session factory.
     *
     * @param pSessionFactory pSessionFactory
     */
    public void setSessionFactory(final SessionFactory pSessionFactory) {
        this.sessionFactory = pSessionFactory;
    }

    /**
     * Logger.
     */
    private final Logger logger = Logger.getLogger(DataDaoImpl.class.getName());

    /**
     * Gets session factory.
     *
     * @return sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public StudentEntity findStudentById(final Integer id) {
        try {

            final Session session = sessionFactory.openSession();
            try {
                Transaction tx = session.getTransaction();
                try {
                    tx.begin();
                    StudentEntity studentEntity = (StudentEntity) session.load(StudentEntity.class, id);
                    tx.commit();
                    return studentEntity;
                } catch (final HibernateException e) {
                    tx.rollback();
                    String message = "Error running transaction";
                    logger.log(Level.SEVERE, message, e);
                    /*throw new CABException(message, e);*/
                    throw e;
                }
            } finally {
                try {
                    session.close();
                } catch (final HibernateException e) {
                    String message = "Error closing hibernate session in findStudentById";
                    logger.log(Level.SEVERE, message, e);
                    throw e;
                }
            }
        } catch (RuntimeException e) {
            String message = "Error finding RegionBy Id rule for id:" + id;
            logger.log(Level.SEVERE, message, e);
            throw e;
        }
    }
}
