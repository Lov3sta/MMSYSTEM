package com.example.mmsystem;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public Connection connection;

        public Connection getConnection() {
            final String DBNAME = "Momo_Management_System";
            final String JDBC_URL = "Jdbc:mysql://localhost:3306/" + DBNAME;
            final String USERNAME = "Rafia";
            final String PASSWORD = "R@@123";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;

        }
    }


