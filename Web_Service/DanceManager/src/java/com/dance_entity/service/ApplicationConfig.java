/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dance_entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author dcod1
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.dance_entity.service.AttendanceFacadeREST.class);
        resources.add(com.dance_entity.service.ClassFacadeREST.class);
        resources.add(com.dance_entity.service.PaymentsFacadeREST.class);
        resources.add(com.dance_entity.service.PermissionsFacadeREST.class);
        resources.add(com.dance_entity.service.ReportFacadeREST.class);
        resources.add(com.dance_entity.service.SkillFacadeREST.class);
        resources.add(com.dance_entity.service.UsersFacadeREST.class);
        resources.add(com.dance_entity.service.WagesFacadeREST.class);
    }
    
}
