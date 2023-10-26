///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package pdc_lingobridge;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DBManager {
//    private static final String DB_URL = "jdbc:derby://localhost:1527/LingoBridge";
//    private static final String DB_USER = "pdc";
//    private static final String DB_PASSWORD = "pdc";
//
//    private Connection connection;
//
//    public DBManager() {
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isUsernameAvailable(String username) {
//        String query = "SELECT COUNT(*) FROM USERS WHERE USERNAME = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int count = resultSet.getInt(1);
//                return count == 0; // Username is available if count is 0
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean insertNewUser(String username) {
//        if (isUsernameAvailable(username)) {
//            String query = "INSERT INTO USERS (USERNAME, SCORE) VALUES (?, 0)";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, username);
//                return preparedStatement.executeUpdate() > 0;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//}
//
package pdc_lingobridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private static final String DB_URL = "jdbc:derby://localhost:1527/LingoBridge";
    private static final String DB_USER = "pdc";
    private static final String DB_PASSWORD = "pdc";

    private Connection connection;

    public DBManager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserManagement getUserByUsername(String username) {
        String query = "SELECT USERNAME, SCORE FROM USERS WHERE USERNAME = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String foundUsername = resultSet.getString("USERNAME");
                int score = resultSet.getInt("SCORE");
                return new UserManagement(foundUsername, score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUserScore(UserManagement user) {
        String query = "UPDATE USERS SET SCORE = ? WHERE USERNAME = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getScore());
            preparedStatement.setString(2, user.getUsername());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUsernameAvailable(String username) {
        String query = "SELECT COUNT(*) FROM USERS WHERE LOWER(USERNAME) = LOWER(?)";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 0; // Username is available if count is 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean insertNewUser(String username) {
        if (isUsernameAvailable(username)) {
            String query = "INSERT INTO USERS (USERNAME, SCORE) VALUES (?, 0)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                return preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
