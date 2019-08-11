package service;

import dao.AddressDAO;
import db.mysql5.SessionServiceUtil;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.List;

public class AddressDAOService implements AddressDAO {


    public void add(Address address) {
        // открываем сессиюи начинаем транзакцию
        Session session = SessionServiceUtil.openTansactionSession();
        //сохраняем объект
        session.save(address);
        // выполняем транзакцию и закрываем сессию
        SessionServiceUtil.closeTransactionSession();
    }

    public List<Address> getAll() {
        // открываем сессиюи начинаем транзакцию
        Session session = SessionServiceUtil.openTansactionSession();
        //запрос на нативном SQL
        String sql = "SELECT * FROM testdb.address";

        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = ((NativeQuery) query).list();
        // выполняем транзакцию и закрываем сессию
        SessionServiceUtil.closeTransactionSession();
        return addressList;
    }

    public Address getById(Long id) {
        Session session = SessionServiceUtil.openTansactionSession();
        String sql = "SELECT * FROM testdb.address WHERE id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id",id);
        Address address = (Address) query.getSingleResult();
        SessionServiceUtil.closeTransactionSession();
        return address;
    }

    public void update(Address address) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.update(address);
        SessionServiceUtil.closeTransactionSession();
    }

    public void remove(Address address) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.remove(address);
        SessionServiceUtil.closeTransactionSession();}
}
