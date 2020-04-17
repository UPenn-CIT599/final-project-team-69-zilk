package src.entities;

/**
 * This constructs a user class to perform all user activities
 *
 * @author Karen
 */
abstract class User {
    private int userID;
    private String username, password;

    /**
     * This constructs a user class to catch all user log in information
     *
     * @param userID
     * @param username
     * @param password
     */
    protected User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    /**
     * This is a method to set new user name
     *
     * @param username
     */
    public void setName(String username) {
        this.username = username;
    }

    /**
     * This is a method to retrieve password of existing user
     *
     * @return user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This is a method to set new password
     *
     * @param newPassword New password entered by user
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * This is a method to retrieve user name for existing user
     *
     * @return user's user name
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This is a method to retrieve user ID for existing user
     *
     * @return user's user ID
     */
    public int getUserID() {
        return userID;
    }
}

