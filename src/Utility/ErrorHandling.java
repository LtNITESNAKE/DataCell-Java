package Utility;
import java.util.*;

public class ErrorHandling {

    private static final Scanner scanner = new Scanner(System.in);

    public static String promptString(String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.next();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }

    public static int promptInt(String message) {
        while (true) {
            try {

                System.out.println(message);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public static float promptFloat(String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
                scanner.nextLine();
            }
        }
    }

    public static char promptChar(String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.next().charAt(0);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid single character.");
                scanner.nextLine();
            }
        }
    }



    public void displayErrorMessage(String s) {
        System.out.println(s);
    }
}

