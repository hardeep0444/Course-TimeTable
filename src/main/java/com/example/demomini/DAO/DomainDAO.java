package com.example.demomini.DAO;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Domain;

import java.util.List;

public interface DomainDAO {

    boolean addDomain(Domain domObj);
    List<Domain> getDomainList();
    List<Course> getCourseList();
    List<Domain> getDomainByID(int domain_id);
}
