package com.example.demomini.Controller;

import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Domain;
import com.example.demomini.DAO.DAOImplementation.DomainDAOImpl;
import com.example.demomini.DAO.DomainDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;

import java.util.List;

@Path("/domain")
public class DomainController {
    DomainDAO domDAO = new DomainDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_domain(Domain dom) {
        System.out.println(String.valueOf(dom));

        if(domDAO.addDomain(dom)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_domains()
    {
        try {
            List<Domain> domains = domDAO.getDomainList();

            return Response.status(200).entity(domains.toString()).build();
        }
        catch (HibernateException ex) {
            String s = "Error" + ex.getLocalizedMessage();
            return Response.status(200).entity(s).build();
        }
    }

    @GET
    @Path("/get_courses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_courses()
    {
        try {
            List<Course> courses = domDAO.getCourseList();

            return Response.status(200).entity(courses.toString()).build();
        }
        catch (HibernateException ex) {
            String s = "Error" + ex.getLocalizedMessage();
            return Response.status(200).entity(s).build();
        }
    }
}
