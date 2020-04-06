package entities;

public class NormalUser extends User {

    /**
     * This constructs a class to store normal user info
     *
     * @param userID
     * @param username
     * @param password
     */
    public NormalUser(int userID, String username, String password) {
        super(userID, username, password);
    }

}
