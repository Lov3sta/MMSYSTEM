package com.example.mmsystem.Admin;

import com.example.mmsystem.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminRepository {
    public static int insert(UserAdmin admin) {
        DBConnection addNow = new DBConnection();
        Connection addDB = addNow.getConnection();


        String Query = "INSERT INTO user(id,Username,Password,FirstName,Lastname,Contact,Email) VALUES(?,?,?,?,?,?,?);";
        int res = 0;

        try {
            PreparedStatement ps = addDB.prepareStatement(Query);
            ps.setInt(1,admin.getId());
            ps.setString(2, admin.getUsername());
            ps.setString(3, admin.getPassword());
            ps.setString(4, admin.getFirstName());
            ps.setString(5, admin.getLastname());
            ps.setString(6, admin.getContact());
            ps.setString(7, admin.getEmail());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;


    }}
