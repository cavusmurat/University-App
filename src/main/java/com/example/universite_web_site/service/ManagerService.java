/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.service;


import com.example.universite_web_site.model.Announcement;
import com.example.universite_web_site.model.ResponseModel;
import com.example.universite_web_site.model.Staff;

import java.util.List;

/**
 *
 * @author Murat
 */
public interface ManagerService {
    
    public ResponseModel<Boolean> addAnnouncement(String title , String text);
    
    public ResponseModel<Boolean> removeAnnouncement(Long id);

    public ResponseModel<List<Staff>> displayStaff();
    
    //public ResponseModel<Announcement> updateAnnouncement(Long id , String title , String text);
    
    public ResponseModel<List<Announcement>> displayAnnouncements();
    
    public ResponseModel<Boolean> addStaff(String name , String surname , String title);
    
    public ResponseModel<Boolean> removeStaff(Long id);


    
    
}
