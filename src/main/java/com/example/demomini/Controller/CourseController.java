package com.example.demomini.Controller;

import com.example.demomini.Bean.Student;
import com.example.demomini.DAO.CourseDAO;
import com.example.demomini.DAO.DAOImplementation.CourseDAOImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;

import java.util.List;

@Path("/course")
public class CourseController {

    CourseDAO courseDAO = new CourseDAOImpl();

    @GET
    @Path("/get_students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_students()
    {
        try {
            List<Student> students = courseDAO.getStudentList();
            return Response.status(200).entity(students.toString()).build();
        }
        catch (HibernateException ex) {
            String s = "Error" + ex.getLocalizedMessage();
            return Response.status(200).entity(s).build();
        }
    }
}
