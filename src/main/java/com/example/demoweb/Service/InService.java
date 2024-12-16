package com.example.demoweb.Service;

import com.example.demoweb.Model.User;

import javax.servlet.http.HttpServletRequest;

public interface InService {
    User signIn(HttpServletRequest req, String username, String password);
    Boolean checkUser(String username);
    void signUp(User user);


}
