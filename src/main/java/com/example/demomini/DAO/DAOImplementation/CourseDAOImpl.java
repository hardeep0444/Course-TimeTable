package com.example.demomini.DAO.DAOImplementation;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Student;
import com.example.demomini.DAO.CourseDAO;
import com.example.demomini.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public List<Student> getStudentList() {

        try {
            Session session = HibernateSessionUtil.getSession();
            List<Student> studentList = new ArrayList<>();

            for (final Object d : session.createQuery("from Student ").list()) {
                studentList.add((Student) d);
            }
            return studentList;
        }
        catch (HibernateException ex) {
            System.out.println("Unable to get Student List : "+ex.getLocalizedMessage());

            return null;
        }

    }
}
