package com.example.demomini.Controller;

import com.example.demomini.Bean.Course;
import com.example.demomini.DAO.DAOImplementation.StudentDAOImpl;
import com.example.demomini.DAO.StudentDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;

import java.util.List;

@Path("/student")
public class StudentController {

    StudentDAO studentDAO = new StudentDAOImpl();

    @GET
    @Path("/get_courses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_courses()
    {
        try {
            List<Course> courses = studentDAO.getCourseList();

            return Response.status(200).entity(courses.toString()).build();
        }
        catch (HibernateException ex) {
            String s = "Error" + ex.getLocalizedMessage();
            return Response.status(200).entity(s).build();
        }
    }
}
