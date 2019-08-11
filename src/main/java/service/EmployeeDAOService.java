package service;

import dao.EmployeeDAO;
import db.mysql5.SessionServiceUtil;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.List;

public class EmployeeDAOService implements EmployeeDAO {
    public void add(Employee employee) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.save(employee);
        SessionServiceUtil.closeTransactionSession();;
    }

    public List<Employee> getAll() {
        Session session = SessionServiceUtil.openTansactionSession();
        String sql = "SELECT * FROM testdb.employee";
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = ((NativeQuery) query).list();
        SessionServiceUtil.closeTransactionSession();
        return employeeList;
    }

    public Employee getById(Long id) {
        Session session = SessionServiceUtil.openTansactionSession();
        String sql = "SELECT * FROM testdb.employee WHERE id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id",id);
        Employee employee = (Employee) query.getSingleResult();
        SessionServiceUtil.closeTransactionSession();
        return employee;
    }

    public void update(Employee employee) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.update(employee);
        SessionServiceUtil.closeTransactionSession();
    }

    public void remove(Employee employee) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.remove(employee);
        SessionServiceUtil.closeTransactionSession();
    }
}
