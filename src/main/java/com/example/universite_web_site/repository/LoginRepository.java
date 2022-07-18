/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.repository;

import com.example.universite_web_site.databaseconnection.DatabaseConnection;
import com.example.universite_web_site.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Murat
 */
public class LoginRepository {
    
    private Connection con = DatabaseConnection.getCon();
    
    
    public Manager login(long id , String password){
        Manager manager = new Manager();
        String sql="SELECT * FROM MANAGER WHERE ID=? AND PASSWORD=? ";
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {            
            ps=con.prepareStatement(sql);           
            ps.setLong(1, id);
            ps.setString(2, password);
            rs=ps.executeQuery();            
            if(rs.next()){                
                manager.setId(rs.getLong("ID"));
                manager.setName(rs.getString("NAME"));
                manager.setPassword(rs.getString("PASSWORD"));                              
                manager.setSurname(rs.getString("SURNAME"));
                              
                return manager;
            }else{
                return null;
            }
        } catch (SQLException ex) {            
            ex.printStackTrace();
            return null;
        }
    }     
}
