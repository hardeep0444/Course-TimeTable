package com.example.demomini.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int domain_id;

    @Column(nullable = false)
    private String domain_name;

    @OneToMany
    @JoinColumn(name = "courses_domain")
    List<Course> coursesOffered = new ArrayList<>();

    public Domain(int domain_id, String domain_name, List<Course> coursesOffered) {
        this.domain_id = domain_id;
        this.domain_name = domain_name;
        this.coursesOffered = coursesOffered;
    }

    public Domain() {
    }

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public List<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<Course> coursesOffered) {
        this.coursesOffered = coursesOffered;
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
