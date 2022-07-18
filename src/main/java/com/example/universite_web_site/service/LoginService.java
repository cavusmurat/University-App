/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.service;


import com.example.universite_web_site.model.Manager;
import com.example.universite_web_site.model.ResponseModel;

/**
 *
 * @author Murat
 */
public interface LoginService {
    
    public ResponseModel<Manager> login(Long id, String password);
    
    public ResponseModel<Boolean> logout();
    
}
