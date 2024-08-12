package DataCell_Department;
import java.util.*;
public class Menu {
     Scanner scanner;
    ConstantVal Const;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int AdmintratorMenu() {
        System.out.println("DataCell Department Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. Display Student Information");
        System.out.println("4. Display All Students");
        System.out.println("5. Search Student by ID");
        System.out.println("6. Sort Students by ID");
        System.out.println("7. Manage Fees");
        System.out.println("8. Manage Fines");
        System.out.println("9. Enrollment of student ");
        System.out.println("10. Course Display By ID");
        System.out.println("11. Student Details Add");
        System.out.println("12. Generate Transcript");
        System.out.println("13. Manage Course GPA");
        System.out.println("14. Manage CGPA ");
        System.out.println("15. Add University Courses");
        System.out.println("16. EXIT");
        System.out.println("Enter your choice: ");
        return scanner.nextInt();
    }
    public int  Menuforuser() {
        System.out.println("DataCell Department Menu:" );
        System.out.println("3. Display Student Information" );
        System.out.println("4. Display All Students" );
        System.out.println("5. Search Student by ID" );
        System.out.println("6. Sort Students by ID" );
        System.out.println("10. Course Display By ID" );
        System.out.println("12. Generate Transcript" );
        System.out.println("16. EXIT" );
        System.out.println("Enter your choice");
        return scanner.nextInt();

    }
    void generateTranscript(DataCell  department, int index)
    {
        department.getStuds()[index].getCgpa();
        System.out.println(STR."------- Transcript for Student ID: \{department.getStuds()[index].getID()} -------");
        System.out.println(STR."Name: \{department.getStuds()[index].getName()}");
        System.out.println(STR."Admission Date: \{department.getStuds()[index].enroll.getAdd_date()}");

        System.out.println("------- Courses -------" );
        for (int i = 0; i < ConstantVal.getCourse(); i++)
        {
            System.out.println(STR."Course \{i}1: \{department.getStuds()[index].Course[i].getCourse_names()}");
            System.out.println(STR."Code: \{department.getStuds()[index].Course[i].getCourse_codes()}");
            System.out.println(STR."Credit Hours: \{department.getStuds()[index].Course[i].getCourse_codes()}");
            System.out.println(STR."Grade: \{department.getStuds()[index].Course[i].getGrades()}");
            System.out.println(STR."Prerequisite Course: \{department.getStuds()[index].Course[i].getPrerequisite_course()}");
            System.out.println(STR."Prerequisite Completed: \{department.getStuds()[index].Course[i].isPrerequisite_completed() ? "Yes" : "No"}");
            System.out.println("------------------------" );
        }

        System.out.println(STR."CGPA: \{department.getStuds()[index].getCgpa()}");
    }
    void viewUserProfile(String role)
    {
         System.out.println("Welcome to the system!");
         System.out.println( "User Profile:");
         System.out.println("-----------------------");
         System.out.println(STR."Role: \{role}");
         System.out.println("------------------------");
    }
}