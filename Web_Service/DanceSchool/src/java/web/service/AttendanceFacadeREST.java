/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import web.Attendance;

/**
 *
 * @author dcod1
 */
@Stateless
@Path("web.attendance")
public class AttendanceFacadeREST extends AbstractFacade<Attendance> {

    @PersistenceContext(unitName = "DanceSchoolPU")
    private EntityManager em;

    public AttendanceFacadeREST() {
        super(Attendance.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Attendance entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Attendance entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
    
    @GET
    @Path("findAttendee/{classID}/{StudentID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Attendance findAttendee(@PathParam("classID") Integer classID, @PathParam("StudentID") Integer studentID){
        return super.findAttendee(classID, studentID);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Attendance find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Attendance> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Attendance> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("countAttend/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String countAttendbyClassID(@PathParam("id") Integer id) {
        return String.valueOf(super.countAttendbyClassID(id));
    }
    
    @GET
    @Path("showAttend/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Attendance> showAttendbyClassID(@PathParam("id") Integer id) {
        return super.showAttendbyClassID(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
