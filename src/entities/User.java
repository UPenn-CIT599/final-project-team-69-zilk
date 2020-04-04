package entities;

abstract class User {
    private int userID;
    private String username, password;

    protected User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public int getUserID() {
        return userID;
    }
}

