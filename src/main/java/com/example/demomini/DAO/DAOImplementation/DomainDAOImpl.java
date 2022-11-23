package com.example.demomini.DAO.DAOImplementation;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Domain;
import com.example.demomini.DAO.DomainDAO;
import com.example.demomini.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DomainDAOImpl implements DomainDAO {

    @Override
    public boolean addDomain(Domain domObj) {
        try(Session session = HibernateSessionUtil.getSession()) {

            Transaction transaction = session.beginTransaction();
            session.persist(domObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex)
        {
            System.out.println("Hibernate Exception");;
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }

    //get all the domains
    @Override
    public List<Domain> getDomainList() {
        try {
            Session session = HibernateSessionUtil.getSession();
            List<Domain> domainList = new ArrayList<>();

            for (final Object d : session.createQuery("from Domain ").list()) {
                domainList.add((Domain) d);
            }
            return domainList;
        }
        catch (HibernateException ex) {
            System.out.println("Unable to get Domain List : "+ex.getLocalizedMessage());

            return null;
        }
    }

    //get all the courses by domain
    @Override
    public List<Course> getCourseList() {
        try {
            Session session = HibernateSessionUtil.getSession();
            List<Course> courseList = new ArrayList<>();

            for (final Object d : session.createQuery("from Course ").list()) {
                courseList.add((Course) d);
            }
            return courseList;
        }
        catch (HibernateException ex) {
            System.out.println("Unable to get Course List : "+ex.getLocalizedMessage());

            return null;
        }
    }
}