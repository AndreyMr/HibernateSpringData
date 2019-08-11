package db.mysql5;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionServiceUtil {
    private static Session session;
    private static Transaction transaction;

    public static Session getSession() {
        return session;
    }

    public static Transaction getTransaction() {
        return transaction;
    }
    public static Session openSession(){return HibernateSessionFactoryUtils.getSessionFactory().openSession();}

    public static Session openTansactionSession(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }
    public static void closeSessino(){
        session.close();
    }
    public static void closeTransactionSession(){
        transaction.commit();
        closeSessino();
    }
}
