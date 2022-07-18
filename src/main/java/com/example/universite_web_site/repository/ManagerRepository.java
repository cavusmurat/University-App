/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.universite_web_site.repository;

import com.example.universite_web_site.databaseconnection.DatabaseConnection;
import com.example.universite_web_site.model.Announcement;
import com.example.universite_web_site.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Murat
 */
public class ManagerRepository {

    private Connection con = DatabaseConnection.getCon();

    public List<Announcement> displayAnnouncements() {
        List list = new ArrayList();
        String sql = "SELECT * FROM ANNOUNCEMENT ";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getLong("ID"));
                announcement.setText(rs.getString("TEXT"));
                announcement.setTitle(rs.getString("TITLE"));
                list.add(announcement);

            }

        } catch (SQLException ex) {
            return null;
        }

        return list;
    }

    public List<Staff> displayStaff() {
        List list = new ArrayList();
        String sql = "SELECT * FROM STAFF ";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getLong("ID"));
                staff.setName(rs.getString("NAME"));
                staff.setSurname(rs.getString("SURNAME"));
                staff.setTitle(rs.getString("TITLE"));
                list.add(staff);
            }

        } catch (SQLException ex) {
            return null;
        }

        return list;
    }

    public int insertStaff(String name, String surname, String title) {
        String sql = "INSERT INTO STAFF (ID,NAME,SURNAME,TITLE) SELECT MAX(ID)+1 ,?,?,? FROM staff";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, title);
            return ps.executeUpdate();
            

        } catch (SQLException ex) {
            return -1;
        }   
    }
    
    
    public int deleteStaff(Long id){
        String sql="DELETE FROM STAFF WHERE ID=?";
        
        PreparedStatement ps=null;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1,id);
            return ps.executeUpdate();
        }catch(SQLException ex){            
            return -1;
        }
    }
    
    public int insertAnnouncement(String title , String text){
        String sql="INSERT INTO ANNOUNCEMENT (ID,TITLE,TEXT) SELECT MAX(ID)+1 , ? , ? from announcement";
        PreparedStatement ps = null;

        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, text);
            return ps.executeUpdate();

        } catch (SQLException ex) {
            return -1;
        }
    }
    
    public int deleteAnnouncement(Long id){
        String sql="DELETE FROM ANNOUNCEMENT WHERE ID=?";
        PreparedStatement ps=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,id);
            return ps.executeUpdate();
        }catch(SQLException ex){
            return -1;
        }
    }

}
