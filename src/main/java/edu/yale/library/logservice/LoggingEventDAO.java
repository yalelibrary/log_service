package edu.yale.library.logservice;

import org.slf4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static org.slf4j.LoggerFactory.getLogger;

public class LoggingEventDAO {

    private final Logger logger = getLogger(this.getClass());

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public LoggingEventDAO() {
        super();
    }

    public void persist(LoggingEvent transientInstance) {
        Session session = null;
        Transaction t = null;
        try {
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            int o = (Integer) session.save(transientInstance);
            session.flush();
            t.commit();
            logger.debug("Saved object id={}", o);
        } catch (RuntimeException re) {
            if (t != null) {
                t.rollback();
            }
            logger.error("Persist failed", re);
            throw re;
        } finally {
            try {
                if (session!= null) {
                    session.close();
                }
            } catch (HibernateException e) {
                logger.error("Error closing session", e);
            }
        }
    }

}