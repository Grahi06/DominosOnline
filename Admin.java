package model;

public class Admin extends User {

    private String role;

    // Constructor
    public Admin(int userId, String username, String password, String email, String role) {
        super(userId, username, password, email);  // calling parent constructor
        this.role = role;
    }

    // Getter
    public String getRole() {
        return role;
    }

    // Setter
    public void setRole(String role) {
        this.role = role;
    }

    // Admin specific method
    public void manageOrder() {
        System.out.println("Admin is managing orders...");
    }

    // Method Overriding (Polymorphism)
    @Override
    public void displayUser() {
        System.out.println("---- Admin Details ----");
        System.out.println("Admin ID: " + getUserId());
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Role: " + role);
    }

    @Override
    public String toString() {
        return getUserId() + "," + getUsername() + "," + getEmail() + "," + role;
    }
}