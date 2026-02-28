package model;

public class User {

    // Static data member (total users counter)
    private static int userCount;

    // Instance variables (Data Members)
    private int userId;
    private String username;
    private String password;
    private String email;

    // Static Block (executed once when class loads)
    static {
        userCount = 0;
        System.out.println("User class loaded...");
    }

    // Constructor
    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        userCount++;
    }

    // Getter methods
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Static method
    public static int getUserCount() {
        return userCount;
    }

    // Method to display user info
    public void displayUser() {
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }

    // Overriding toString()
    @Override
    public String toString() {
        return userId + "," + username + "," + email;
    }
}