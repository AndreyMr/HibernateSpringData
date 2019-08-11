package service;


import dao.ProjectDAO;
import db.mysql5.SessionServiceUtil;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.List;

public class ProjectDAOService implements ProjectDAO {
    public void add(Project project) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.save(project);
        SessionServiceUtil.closeTransactionSession();
    }

    public List<Project> getAll() {
        Session session = SessionServiceUtil.openTansactionSession();

        String sql = "SELECT * FROM testdb.project";
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = ((NativeQuery) query).list();
        SessionServiceUtil.closeTransactionSession();
        return projectList;
    }

    public Project getById(Long id) {
        Session session = SessionServiceUtil.openTansactionSession();
        String sql = "SELECT * FROM testdb.project WHERE id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id",id);
        Project project = (Project) query.getSingleResult();
        return project;
    }

    public void update(Project project) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.update(project);
        SessionServiceUtil.closeTransactionSession();
    }

    public void remove(Project project) {
        Session session = SessionServiceUtil.openTansactionSession();
        session.remove(project);
        SessionServiceUtil.closeTransactionSession();
    }
}
