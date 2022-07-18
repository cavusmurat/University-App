/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.serviceImpl;

import com.example.universite_web_site.model.Announcement;
import com.example.universite_web_site.model.ResponseModel;
import com.example.universite_web_site.model.Staff;
import com.example.universite_web_site.repository.ManagerRepository;
import com.example.universite_web_site.service.ManagerService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murat
 */
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository = new ManagerRepository();

    @Override
    public ResponseModel<Boolean> addAnnouncement(String title, String text) {
        ResponseModel responsemodel = new ResponseModel();
        if(managerRepository.insertAnnouncement(title, text)>0){
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Successfully added!");
            responsemodel.setResponseObject(true);   
       
        } else {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);
        }
        return responsemodel;
    }


    @Override
    public ResponseModel<Boolean> removeAnnouncement(Long id) {
        ResponseModel responsemodel = new ResponseModel();
        if(managerRepository.deleteAnnouncement(id)>0){
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Successfully deleted!");
            responsemodel.setResponseObject(true);   
       
        } else {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);
        }
        return responsemodel;
    }

    

    @Override
    public ResponseModel<Boolean> addStaff(String name, String surname, String title) {
        ResponseModel responsemodel = new ResponseModel();
        if (managerRepository.insertStaff(name, surname, title)>0) {
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Successfully added!");
            responsemodel.setResponseObject(true);

        } else {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);
        }

        return responsemodel;
    }

    @Override
    public ResponseModel<Boolean> removeStaff(Long id) {
        ResponseModel responsemodel = new ResponseModel();
        if (managerRepository.deleteStaff(id)>0) {
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Successfully removed!");
            responsemodel.setResponseObject(true);

        } else {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);
        }
        return responsemodel;
    }

    @Override
    public ResponseModel<List<Announcement>> displayAnnouncements() {
        ResponseModel responsemodel = new ResponseModel();
        List<Announcement> list = new ArrayList();
        list.addAll(managerRepository.displayAnnouncements());
        if(list==null){
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);   
        } else {
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Succesful!");
            responsemodel.setResponseObject(list);      
        }     
        return responsemodel;
        
    }

    @Override
    public ResponseModel<List<Staff>> displayStaff() {
        ResponseModel responsemodel = new ResponseModel();
        List<Staff> list = new ArrayList();
        list.addAll(managerRepository.displayStaff());
        if (list == null) {
            responsemodel.setIsSuccess(false);
            responsemodel.setMessage("Transaction failed!");
            responsemodel.setResponseObject(false);
        } else {
            responsemodel.setIsSuccess(true);
            responsemodel.setMessage("Succesful!");
            responsemodel.setResponseObject(list);
        }
        return responsemodel;
    }
}
