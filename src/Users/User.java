package Users;

public class User {
    private String username;
    private String password;
    private  String role;

    public User(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean authenticate(String enteredPassword)
    {
        if(password.equals(enteredPassword))
            return true;
        return false;
    }
}