/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murat
 */
public class DatabaseConnection {
    
    private static Connection con=null;

    public static Connection getCon() {
        if(con==null){
            con=connectDatabase();
        }
        return con;
    }

    public static void setCon(Connection con) {
        DatabaseConnection.con = con;
    }
    
    public static Connection connectDatabase(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university_database","root","");
            System.out.println("Connected");
            return con;   
        }catch(SQLException ex){
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
