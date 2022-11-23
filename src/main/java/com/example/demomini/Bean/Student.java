package com.example.demomini.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;

    @Column(unique = true, nullable = false)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(unique = true, nullable = false)
    private String email;

//    @ManyToMany(mappedBy = "studentsEnrolled")
//    List<Course> coursesEnrolled = new ArrayList<>();


    public Student() {
    }

    public Student(int student_id, String roll_number, String first_name, String last_name, String email) {
        this.student_id = student_id;
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
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
