package com.example.demomini.DAO.DAOImplementation;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Course_Schedule;
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

    @Override
    public List<Course> getCourseByID(int course_id) {
        try {
            Session session = HibernateSessionUtil.getSession();
            List<Course> courseList = new ArrayList<>();

            for (final Object d : session.createQuery("from Course where course_id ="+ course_id).list()) {
                courseList.add((Course) d);
            }
            return courseList;
        }
        catch (HibernateException ex) {
            System.out.println("Unable to get Course List : "+ex.getLocalizedMessage());

            return null;
        }
    }

//    @Override
//    public List<Course_Schedule> getCourseSchedule(int course_id) {
//        try
//        {
//            Session session = HibernateSessionUtil.getSession();
//            List<Course_Schedule> courseScheduleList = new ArrayList<>();
//
//            for (final Object d : session.createQuery("from Course_Schedule where course = "+course_id).list()) {
//                courseScheduleList.add((Course_Schedule) d);
//            }
//            return courseScheduleList;
//        }
//        catch (HibernateException ex) {
//            System.out.println("Unable to get Course Schedule List : "+ex.getLocalizedMessage());
//
//            return null;
//        }
//    }


}
