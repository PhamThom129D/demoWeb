package com.example.demoweb.Service;

import com.example.demoweb.Model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService implements InService {

    @Override
    public User signIn(HttpServletRequest req, String username, String password) {
        String query = "SELECT * FROM user WHERE LOWER(username) = LOWER(?) AND password = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("userID");
                String phonenumber = rs.getString("phonenumber");
                String address = rs.getString("address");
                User user = new User(userID, username, password, phonenumber, address);

                HttpSession session = req.getSession(true);
                session.setAttribute("loggedInUser", user);
                return user;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean checkUser(String username) {
        String query = "SELECT * FROM user WHERE LOWER(username) = LOWER(?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            return !rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void signUp(User user) {
        String query = "INSERT INTO user(username, password, phonenumber, address) VALUES(?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhonenumber());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
