package com.example.demomini.DAO.DAOImplementation;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Student;
import com.example.demomini.DAO.StudentDAO;
import com.example.demomini.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

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
            System.out.println("Unable to get Student List : "+ex.getLocalizedMessage());

            return null;
        }
    }
}
