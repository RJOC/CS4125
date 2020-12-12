/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import web.Attendance;
import web.Users;
import web.Wages;

/**
 *
 * @author dcod1
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public int countbyID(int id) {
      int test = getEntityManager().createNamedQuery("Users.findAttendanceCountbyStudentID").setParameter("studentID", id).getResultList().size();
      return test;
    }
    
    public int countAttendbyClassID(int id) {
      int test = getEntityManager().createNamedQuery("Class.findAttendanceByClassID").setParameter("classID", id).getResultList().size();
      return test;
    }
    
    public Users login(String u, String p){
        return(Users) getEntityManager().createNamedQuery("Users.login").setParameter("username", u).setParameter("password",p).getSingleResult();
    }
    

    public Users finduser(String u){
        Users result  =(Users) getEntityManager().createNamedQuery("Users.findByUsername").setParameter("username", u).getSingleResult();
        return result;
    }
    
    public Attendance findAttendee(int c, int s){
        Attendance result = (Attendance) getEntityManager().createNamedQuery("Attendance.findByStudentClassID").setParameter("classID", c).setParameter("studentID", s).getSingleResult();
        return result;
    }
    
    public List<T> findClassesbyTeacherID(int id){
        List<T> result = getEntityManager().createNamedQuery("Users.findClassbyTeacherID").setParameter("teacherID", id).getResultList();
        return result;
    }
    
    public List<T> findWagesbyTeacherID(int id){
        List<T> result = getEntityManager().createNamedQuery("Users.findWagesbyTeacherID").setParameter("teacherID", id).getResultList();
        return result;
    } 
    
    public List<T> findReportbyTeacherID(int id){
        List<T> result = getEntityManager().createNamedQuery("Users.findReportbyTeacherID").setParameter("teacherID", id).getResultList();
        return result;
    } 
    
    public List<T> findReportbyStudentID(int id){
        List<T> result = getEntityManager().createNamedQuery("Users.findReportbyStudentID").setParameter("studentID", id).getResultList();
        return result;
    }
 
    public List<T> AttendingbyID(int id) {
       return getEntityManager().createNamedQuery("Users.findAttendanceCountbyStudentID").setParameter("studentID", id).getResultList();

    }
   
    
    
}
