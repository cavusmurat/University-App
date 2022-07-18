
package com.example.universite_web_site.controller;


import com.example.universite_web_site.model.Announcement;
import com.example.universite_web_site.model.ResponseModel;
import com.example.universite_web_site.model.Staff;
import com.example.universite_web_site.serviceImpl.ManagerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {

    private ManagerServiceImpl managerService = new ManagerServiceImpl();

    @PostMapping("/add-announcement")
    public ResponseEntity<ResponseModel<Boolean>> addAnnouncement(@RequestParam String title , @RequestParam String text){
        ResponseModel<Boolean> responsemodel = new ResponseModel();
        responsemodel=managerService.addAnnouncement(title,text);

        return ResponseEntity.ok(responsemodel);
    }

    @GetMapping("/display-announcement")
    public ResponseEntity<ResponseModel<List<Announcement>>> displayAnnouncement(){
        ResponseModel<List<Announcement>> responsemodel = new ResponseModel();
        responsemodel=managerService.displayAnnouncements();

        return ResponseEntity.ok(responsemodel);
    }


    @PostMapping("/delete-announcement")
    public ResponseEntity<ResponseModel<Boolean>> deleteAnnouncement(@RequestParam Long id) {
        ResponseModel<Boolean> responsemodel = new ResponseModel();
        responsemodel = managerService.removeAnnouncement(id);

        return ResponseEntity.ok(responsemodel);
    }

    @PostMapping("/add-staff")
    public ResponseEntity<ResponseModel<Boolean>> addStaff(@RequestParam String name ,@RequestParam String surname , @RequestParam String title) {
        ResponseModel<Boolean> responsemodel = new ResponseModel();
        responsemodel = managerService.addStaff(name,surname,title);

        return ResponseEntity.ok(responsemodel);
    }

    @GetMapping("/display-staff")
    public ResponseEntity<ResponseModel<List<Staff>>> displayStaff(){
        ResponseModel<List<Staff>> responsemodel = new ResponseModel();
        responsemodel=managerService.displayStaff();

        return ResponseEntity.ok(responsemodel);
    }

    @PostMapping("/delete-staff")
    public ResponseEntity<ResponseModel<Boolean>> deleteStaff(@RequestParam Long id) {
        ResponseModel<Boolean> responsemodel = new ResponseModel();
        responsemodel = managerService.removeStaff(id);

        return ResponseEntity.ok(responsemodel);
    }
}