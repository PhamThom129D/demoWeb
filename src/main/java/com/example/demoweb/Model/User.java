package com.example.demoweb.Model;

public class User {
    private int userID;
    private String username;
    private String password;
    private String phonenumber;
    private String address;

    public User(int userID, String username, String password, String phonenumber, String address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public User(String username, String password, String phonenumber, String address) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
