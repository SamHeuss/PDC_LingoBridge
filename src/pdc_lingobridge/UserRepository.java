package pdc_lingobridge;

public class UserRepository {
    private DBManager dbManager;

    public UserRepository() {
        dbManager = new DBManager();
    }

    public UserManagement checkUser(String username) {
        // Check if the user exists in the database using the DBManager
        UserManagement user = dbManager.getUserByUsername(username);

        if (user != null) {
            return user;
        } else {
            // If the user doesn't exist, create a new user and return it.
            return new UserManagement(username, 0);
        }
    }

    public void updateScore(UserManagement user) {
        // Update the user's score in the database using the DBManager
        dbManager.updateUserScore(user);
    }
}
