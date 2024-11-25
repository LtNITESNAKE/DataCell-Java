package DataCell_Department;
import java.util.*;
public class AutenticatedUser {
    private int index;
    private String role;


    public int getIndex() {
        return index;
    }

    public String getRole() {
        return role;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setRole(String role) {
        this.role = role;
    }
    AutenticatedUser authenticateUser(String enteredUsername, String enteredPassword, User[] users, int numUsers)
    {
        for (int i = 0; i < numUsers; i++)
        {
            if (users[i].getUsername().equals(enteredUsername) && users[i].getPassword().equals(enteredPassword))
            {
                AutenticatedUser authUser = null;
                authUser.index=i;
                authUser.role = "Administrator";
                return authUser;
            }
        }
        // Authentication failed
        AutenticatedUser authUser = null;
        authUser.index= -1;
        authUser.role = "user";
        return authUser;
    }
    AutenticatedUser loginUser(User[] users, int numUsers) {
        String enteredUsername, enteredPassword;
        Scanner cin=new Scanner(System.in);

        System.out.println("Enter your username: ");
        enteredUsername=cin.next();

        System.out.println("Enter your password: ");
        enteredPassword=cin.next();

        return authenticateUser(enteredUsername, enteredPassword, users, numUsers);
    }
}



