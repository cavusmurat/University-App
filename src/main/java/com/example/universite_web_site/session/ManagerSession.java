/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.session;


import com.example.universite_web_site.model.Manager;

/**
 *
 * @author Murat
 */
public class ManagerSession {
    
    private static Manager manager;
    
    
     public static void clear(){
        manager=null;
    }

    public static Manager getManager() {
        return manager;
    }

    public static void setUser(Manager manager) {
        ManagerSession.manager = manager;
    }

    
    
}
