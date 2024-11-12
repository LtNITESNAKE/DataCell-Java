package Users;

import DataCell_Department.Enrollment.Student;
import DataCell_Department.TASKMANAGER.Menu;
import DataCell_Department.TASKMANAGER.TaskManager;
import File_Handler.LoginFile;
import Utility.ConstantVal;
import Utility.ErrorHandling;
import java.util.Scanner;

import static File_Handler.CourseFile.readCoursesFromFile;
import static File_Handler.LoginFile.readLoginCredentials;
import static File_Handler.StudentFile.readStudentsFromFile;

public class Main {

    private static  int MAX_USERS = ConstantVal.getMaxUsers();
    public static  User[] users = new User[MAX_USERS];
    private static int numUsers = 0;
    private static boolean exitProgram;
    private static boolean END ;
    private static   DataCell dataCell = DataCell.inDataCell();


    static{
        exitProgram=true;
        END=false;
    }

    public static void main(String[] args) {

        TaskManager TM = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        // Load existing users from file
        readLoginCredentials("loginData.txt");
        // Restoring the student data to datacell
        readStudentsFromFile(dataCell,"students.txt");
        // Restoring the UniversityCourses
        readCoursesFromFile(dataCell,"University_Course.txt");


        do {
            System.out.println(
                    "\n\n|============================================|\n" +
                            "|\t  <==> Press S for SignUp <==>\t\t     |\n" +
                            "|============================================|\n" +
                            "|\t  <==> Press L for LoginIn <==>\t\t     |\n" +
                            "|============================================|\n");
            char s = scanner.next().charAt(0);
            if (s == 'S' || s == 's') {
                setupUsers(scanner);
            } else if (s == 'L' || s == 'l') {
                authenticateAndPerformTasks(scanner, dataCell, TM);
            }
        } while (!END);

        scanner.close();
    }

    private static void setupUsers(Scanner scanner) {
        System.out.println("---- User Setup ----");

        char newUserOption;
        do {
            if (numUsers < MAX_USERS) {
                System.out.println("Are you a user or administrator? (a/u): ");
                newUserOption = scanner.next().charAt(0);

                System.out.print("Enter username: ");
                String username = scanner.next();
                boolean t=findUserByUsername(username);
                if (t) {
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    String role = (newUserOption == 'a' || newUserOption == 'A') ? "Administrator" : "User";

                    users[numUsers] = new User(username, password, role);
                    numUsers++; // Increment numUsers after adding a new user

                    // Write user credentials to file
                    LoginFile.writeLoginCredentialsToFile(username, password, role, "loginData.txt");
                } else {
                    System.out.println("Username already exists. Please choose a different username.");
                }
            } else {
                System.out.println("Maximum number of users reached.");
                break; // Exit the loop if maximum users reached
            }

            System.out.print("Add another user? (y/n): ");
            newUserOption = scanner.next().charAt(0);
        } while (newUserOption == 'y' || newUserOption == 'Y');
    }


    private static void authenticateAndPerformTasks(Scanner scanner, DataCell dataCell, TaskManager TM) {
        boolean signUpNeeded = numUsers == 0;

        do {
            if (signUpNeeded) {
                setupUsers(scanner);
                signUpNeeded = false;
            }

            System.out.println("---------- LOGIN ----------");
            String enteredUsername = ErrorHandling.promptString("Enter your username: ");
            String enteredPassword = ErrorHandling.promptString("Enter your password: ");

            if (LoginFile.checkLoginCredentials(enteredUsername, enteredPassword, "loginData.txt")) {
                System.out.println("Login successful!");
                String role = LoginFile.getUserRole(enteredUsername, enteredPassword, "loginData.txt");
                Menu.viewUserProfile(role);

                if (role != null) {
                    TM.performTask(dataCell,  role);
                }
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }

        } while (exitProgram);
    }

    private static boolean findUserByUsername(String username) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i] != null && users[i].getUsername().equalsIgnoreCase(username)) {
             break;
            }
        }
        return true;
    }



    public static int getMaxUsers() {
        return MAX_USERS;
    }

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User[] users) {
        Main.users = users;
    }

    public static int setNumUsers(int numUsers) {
        Main.numUsers = numUsers;
        return numUsers;
    }

    public static int getNumUsers() {
        return numUsers;
    }

    public static void setExitProgram(boolean exitProgram) {
        Main.exitProgram = exitProgram;
    }

    public static void setEND(boolean END) {
        Main.END = END;
    }
}
