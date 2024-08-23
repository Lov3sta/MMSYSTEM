package com.example.mmsystem;

import java.sql.Timestamp;

public class TransactionSheet {

    private int id;
    private String CustomerName;
    private String Contact;
    private String Amount;
    private String transactionType;
    private String transactionService;
    private String Save;

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Timestamp date;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getSave() {
        return Save;
    }

    public void setSave(String save) {
        Save = save;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionService() {
        return transactionService;
    }

    public void setTransactionService(String transactionService) {
        this.transactionService = transactionService;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    private String Date;
    private String Time;

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "CustomerName='" + CustomerName + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Amount=" + Amount +
                ", TransactionType='" + transactionType + '\'' +
                ", TransactionService='" + transactionService + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
