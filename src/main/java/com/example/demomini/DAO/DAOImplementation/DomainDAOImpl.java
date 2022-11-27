package com.example.demomini.DAO.DAOImplementation;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Domain;
import com.example.demomini.DAO.DomainDAO;
import com.example.demomini.Util.HibernateSessionUtil;
import jakarta.persistence.Query;
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

    @Override
    public List<Domain> getDomainByID(int d_id) {
        try {
            Session session = HibernateSessionUtil.getSession();
            List<Domain> domainList = new ArrayList<>();

            System.out.println("checking"+d_id);
            for (final Object d : session.createQuery("from Domain where domain_id ="+ d_id).list()) {
                domainList.add((Domain) d);
            }
            return domainList;
        }
        catch (HibernateException ex) {
            System.out.println("Unable to get Domain List : "+ex.getLocalizedMessage());

            return null;
        }
    }

    @Override
    public List<Course> getCoursesByDomain(int d_id) {
        List<Course> c;
        Session session = HibernateSessionUtil.getSession();
        try{
            Query query = session.createQuery("from Domain where domain_id=: d_id");
            query.setParameter("d_id",d_id);
            if(query.getResultList().size()==1) {
                Domain d = (Domain) query.getResultList().get(0);
                c = d.getCoursesOffered();
                return c;
            }
        }
        catch (HibernateException ex){
            System.out.println(ex);
        }
        finally {
            session.close();
        }
        return null;
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
