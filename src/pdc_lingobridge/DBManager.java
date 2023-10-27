package pdc_lingobridge;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String DATABASE_NAME = "LingoBridgeDB";
    private static final String DB_URL = "jdbc:derby:" + DATABASE_NAME + ";create=true";
    private static final String DB_USER = "pdc";
    private static final String DB_PASSWORD = "pdc";

    private Connection connection;
    private static DBManager instance = null;

    public DBManager() {
        establishConnection();
        intializeDatabase();
    }

    private void establishConnection() {
        try {
            // Load the embedded driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void intializeDatabase() {
        createTableUsers();
        createTableSuggestions();
    }

    private void createTableUsers() {
        String createTableSQL = "CREATE TABLE USERS ("
                + "USERNAME VARCHAR(255) UNIQUE, "
                + "SCORE INT)";
        createTableIfNotExists("USERS", createTableSQL);
    }

    private void createTableSuggestions() {
        String createTableSQL = "CREATE TABLE SUGGESTIONS ("
                + "ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " // Auto-generated primary key for each suggestion
                + "USERNAME VARCHAR(255), "
                + "CATEGORY_SUGGESTION VARCHAR(255), "
                + "FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME))"; // Foreign key constraint
        createTableIfNotExists("SUGGESTIONS", createTableSQL);
    }

    private void createTableIfNotExists(String tableName, String createTableSQL) {
        try ( Statement statement = this.connection.createStatement()) {
            if (!isTableExists(tableName, this.connection)) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Created table: " + tableName);
            }
        } catch (SQLException ex) {
            System.out.println("Error creating table " + tableName + ": " + ex.getMessage());
        }
    }

    private boolean isTableExists(String tableName, Connection connection) throws SQLException {
        DatabaseMetaData dbm = connection.getMetaData();
        try ( ResultSet tables = dbm.getTables(null, null, tableName.toUpperCase(), null)) {
            return tables.next();
        }
    }

    public UserManagement getUserByUsername(String username) {
        String query = "SELECT USERNAME, SCORE FROM USERS WHERE USERNAME = ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
            try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                return preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean usernameExists(String username) {
        String query = "SELECT COUNT(*) FROM USERS WHERE LOWER(USERNAME) = LOWER(?)";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Username exists if count is greater than 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    // inside DBManager class
    public List<UserManagement> getAllUsers() {
        List<UserManagement> userList = new ArrayList<>();
        String query = "SELECT USERNAME, SCORE FROM USERS ORDER BY SCORE DESC";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                int score = resultSet.getInt("SCORE");
                userList.add(new UserManagement(username, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void insertSuggestion(String username, String suggestion) {
        try {
            //Connection conn = // Your method to get connection;
            String sql = "INSERT INTO SUGGESTIONS (USERNAME, CATEGORY_SUGGESTION) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, suggestion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> fetchSuggestions() {
        List<String[]> results = new ArrayList<>();
        try {
            String sql = "SELECT USERNAME, CATEGORY_SUGGESTION FROM SUGGESTIONS";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("USERNAME");
                String suggestion = rs.getString("CATEGORY_SUGGESTION");
                results.add(new String[]{username, suggestion});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

//
//    public void addSuggestion(String username, String category) {
//        String query = "INSERT INTO suggested_categories (username, suggested_category) VALUES (?, ?)";
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, username);
//            pstmt.setString(2, category);
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            // handle any errors
//        }
//    }
    public List<DeckSuggestion> getSuggestionsByUser(String username) {
        List<DeckSuggestion> suggestions = new ArrayList<>();
        String query = "SELECT ID, CATEGORY_SUGGESTION FROM SUGGESTIONS WHERE USERNAME = ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String categorySuggestion = resultSet.getString("CATEGORY_SUGGESTION");
                suggestions.add(new DeckSuggestion(username, categorySuggestion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suggestions;
    }

    public List<DeckSuggestion> getAllSuggestions() {
        List<DeckSuggestion> suggestions = new ArrayList<>();
        String query = "SELECT ID, USERNAME, CATEGORY_SUGGESTION FROM SUGGESTIONS";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("USERNAME");
                String categorySuggestion = resultSet.getString("CATEGORY_SUGGESTION");
                suggestions.add(new DeckSuggestion(username, categorySuggestion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suggestions;
    }

    public boolean deleteSuggestion(int suggestionId) {
        String query = "DELETE FROM SUGGESTIONS WHERE ID = ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, suggestionId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException se) {
            if (!((se.getErrorCode() == 45000) && ("08006".equals(se.getSQLState())))) {
                // If it's not the specific exception for successful shutdown, print it
                se.printStackTrace();
            }
        }
    }
}

//package pdc_lingobridge;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBManager {
//
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
//    public UserManagement getUserByUsername(String username) {
//        String query = "SELECT USERNAME, SCORE FROM USERS WHERE USERNAME = ?";
//        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                String foundUsername = resultSet.getString("USERNAME");
//                int score = resultSet.getInt("SCORE");
//                return new UserManagement(foundUsername, score);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public boolean updateUserScore(UserManagement user) {
//        String query = "UPDATE USERS SET SCORE = ? WHERE USERNAME = ?";
//        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, user.getScore());
//            preparedStatement.setString(2, user.getUsername());
//            return preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean isUsernameAvailable(String username) {
//        String query = "SELECT COUNT(*) FROM USERS WHERE LOWER(USERNAME) = LOWER(?)";
//        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, username.toLowerCase());
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
//            try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, username);
//                return preparedStatement.executeUpdate() > 0;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    public boolean usernameExists(String username) {
//        String query = "SELECT COUNT(*) FROM USERS WHERE LOWER(USERNAME) = LOWER(?)";
//        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, username.toLowerCase());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int count = resultSet.getInt(1);
//                return count > 0; // Username exists if count is greater than 0
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//
//    // inside DBManager class
//    public List<UserManagement> getAllUsers() {
//        List<UserManagement> userList = new ArrayList<>();
//        String query = "SELECT USERNAME, SCORE FROM USERS ORDER BY SCORE DESC";
//        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String username = resultSet.getString("USERNAME");
//                int score = resultSet.getInt("SCORE");
//                userList.add(new UserManagement(username, score));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//}
