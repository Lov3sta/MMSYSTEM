package com.example.mmsystem.Admin;

import com.example.mmsystem.DBConnection;
import com.example.mmsystem.TransactionSheet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionSheetRepo {
    public static int insert(TransactionSheet transactionSheet){
        DBConnection addNow = new DBConnection();
        Connection addDB = addNow.getConnection();

        String Query = "INSERT INTO customerDetails (CustomerName ,Contact,Amount,transactionType, transactionService) VALUES(?,?,?,?,?);";
        int res = 0;

        try {
            PreparedStatement ps = addDB.prepareStatement(Query);
            ps.setString(1, transactionSheet.getCustomerName());
            ps.setString(2, transactionSheet.getContact());
            ps.setString(3, transactionSheet.getAmount());
            ps.setString(4, transactionSheet.getTransactionService());
            ps.setString(5, transactionSheet.getTransactionType());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
