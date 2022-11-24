package com.example.demomini.Bean;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int course_id;

    @Column(unique = true, nullable = false)
    private String course_code;

    @Column(nullable = false)
    private String course_name;

    private String facultyName;

    @ManyToMany
    List<Student> studentsEnrolled = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Course_Schedule> courseSchedules;

    public Course(int course_id, String course_code, String course_name, String facultyName, List<Student> studentsEnrolled, List<Course_Schedule> courseSchedules) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.facultyName = facultyName;
        this.studentsEnrolled = studentsEnrolled;
        this.courseSchedules = courseSchedules;
    }

    public Course() {
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public List<Course_Schedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(List<Course_Schedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }

    public String toString() {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(this);
            return json;
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
