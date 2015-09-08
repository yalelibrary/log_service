package edu.yale.library.logservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;


public class LoggingEventDAO {

    private static final Log log = LogFactory.getLog(LoggingEventDAO.class);

    // List<LoggingEvent> loggingEvents = new ArrayList();

    // private final SessionFactory sessionFactory = getSessionFactory();

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public LoggingEventDAO() {
        super();
    }

    public void persist(LoggingEvent transientInstance) {
        log.debug("persisting LoggingEvent instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

}