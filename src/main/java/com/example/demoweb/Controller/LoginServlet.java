package com.example.demoweb.Controller;

import com.example.demoweb.Model.User;
import com.example.demoweb.Service.InService;
import com.example.demoweb.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final InService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "redirectRegister" :
                resp.sendRedirect("authenticate/register.jsp");
                break;
            case "redirectLogin":
                resp.sendRedirect("authenticate/login.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "signIn":
                signInAction(req, resp);
                break;
            case "signUp":
                signUpAction(req, resp);
                break;
            case "forgot":
                forgotAction(req, resp);
                break;
            default:
                resp.sendRedirect("/authenticate/login.jsp");
                break;
        }
    }

    private void signInAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.signIn(req, username, password);
        if (user == null) {
            System.out.println("lỗi");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/authenticate/home.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void signUpAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        User user = new User(username,password,phonenumber,address);
        System.out.println(username);
        if(userService.checkUser(username)){
            userService.signUp(user);
            System.out.println("Đăng ký thành công");
            resp.sendRedirect("/authenticate/login.jsp");
        }else {
            System.out.println("tai khoan da ton tai");
            resp.sendRedirect("/authenticate/register.jsp");
            resp.getWriter().println("<h1>Tai khoan da ton tai</h1>");
        }
    }

    private void forgotAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().println("<h1>Password Reset Page</h1>");
    }

    private void showAlertAndRedirect(HttpServletRequest req, HttpServletResponse resp, String message, String filename) throws IOException, ServletException {
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher(filename);
        dispatcher.forward(req, resp);
    }
}
