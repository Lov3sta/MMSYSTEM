package com.example.mmsystem.Admin;

public class UserAdmin {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String Username;
    private String Password;
    private String FirstName;
    private String Lastname;
    private String Contact;
    private String Email;


    public UserAdmin(){}

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "UserId='" + Username + '\'' +
                ", password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
