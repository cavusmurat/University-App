/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.controller;


import com.example.universite_web_site.model.Manager;
import com.example.universite_web_site.model.ResponseModel;
import com.example.universite_web_site.serviceImpl.LoginServiceImpl;
import com.example.universite_web_site.session.ManagerSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController  {


    private LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
    private Manager manager;

    public Manager getUser() {
        if (this.manager == null) {
            this.manager = new Manager();
        }
        return manager;
    }

    public void setUser(Manager user) {
        this.manager = user;
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateIdPassword(@RequestParam Long id , @RequestParam String password) {
        ResponseModel<Manager> responsemodel;
        responsemodel = loginServiceImpl.login(id, password);
        if (responsemodel.getIsSuccess()) {            
            this.manager = ManagerSession.getManager();
            return ResponseEntity.ok("yonetici.html");
        } else {
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Password","Please enter correctly"));
            return ResponseEntity.ok("login.html");
        }

    }
    @PostMapping("/logout")
    public String logout() {
        this.manager = null;
        //HttpSession session = SessionUtils.getSession();
        //session.invalidate();
        ManagerSession.clear();
        return "login";
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @PostMapping("/test2")
    public ResponseEntity<ResponseModel<String>> test2(@RequestParam String title , @RequestParam String text){
        ResponseModel<String> responsemodel = new ResponseModel();
        responsemodel.setResponseObject(title + " " + text);

        return ResponseEntity.ok(responsemodel);
    }

    @PostMapping("/is-login")
    public ResponseEntity<Boolean> isLogin(){
        if(this.manager==null){
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }
}
