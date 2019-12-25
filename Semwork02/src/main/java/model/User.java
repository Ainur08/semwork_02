package model;

public class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public User(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
