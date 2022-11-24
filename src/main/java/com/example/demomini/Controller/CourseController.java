package com.example.demomini.Controller;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Student;
import com.example.demomini.DAO.CourseDAO;
import com.example.demomini.DAO.DAOImplementation.CourseDAOImpl;
import com.example.demomini.Util.HibernateSessionUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
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
    @GET
    @Path("/get/{c_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_course_by_ID(@PathParam("c_id") int c_id)
    {
        try {
            List<Course> courses = courseDAO.getCourseByID(c_id);
            return Response.status(200).entity(courses.toString()).build();
        }
        catch (HibernateException ex) {
            String s = "Error" + ex.getLocalizedMessage();
            return Response.status(200).entity(s).build();
        }
    }

}
