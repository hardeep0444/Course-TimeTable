package com.example.demomini.DAO;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Student;

import java.util.List;

public interface CourseDAO {

    List<Student> getStudentList();
    List<Course> getCourseByID(int course_id);
}
