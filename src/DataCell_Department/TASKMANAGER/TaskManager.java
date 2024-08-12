package DataCell_Department.TASKMANAGER;

import DataCell_Department.Enrollment.Student;
import File_Handler.StudentFile;
import Users.DataCell;
import Users.Main;
import Utility.CallAllClasses;
import Utility.ErrorHandling;
import Utility.Sorting_Searching;

import java.util.Scanner;

import static DataCell_Department.Courses.UniversityCourse.addUniversityCourses;
import static File_Handler.CourseFile.writeCoursesToFile;
import static Utility.Sorting_Searching.searchStudentByID;

public class TaskManager {
    private final ErrorHandling errorHandler = new ErrorHandling();

    public void performTask(DataCell dataCell, String role) {

        int choice;
        Scanner scanner = new Scanner(System.in);
Menu m=new Menu();
CallAllClasses CAC=new CallAllClasses();
        do {
            System.out.flush();

            if (role.equals("Administrator")) {
                choice=m.AdministratorMenu();
            } else {
                choice=m.Menuforuser();
            }

            switch (choice) {
                case 1:
                    // Adding a new student
                    if (role.equals("Administrator")) {
                    addNewStudent(dataCell,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can add students.");
                    }
                    break;
                case 2:
                    // Updating student information
                    if (role.equals("Administrator")) {
                        updateStudentInfo(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can update student information.");
                    }
                    break;
                case 3:
                    // Displaying student information
                    System.out.println("Enter student id to view information ");
                    int index=searchStudentByID(dataCell,scanner.next());
                    if(index!=-1) {
                        CAC.getM().displayStudentInfoWithCourses(dataCell, index);
                    }else {
                        System.out.println("Student not Found");
                    }
                    break;
                case 4:
                    // Displaying all students
                    CAC.getM().displayAllStudents(dataCell);
                    break;
                case 5:
                    // Searching for a student by ID
                    searchStudentById(dataCell, scanner,CAC);
                    break;
                case 6:
                    // Sorting students by ID
                    Sorting_Searching.sortStudentsByID(dataCell);
                    System.out.println("Students sorted by ID.");
                    break;
                case 7:
                    // Managing student fees
                    if (role.equals("Administrator")) {
                        manageFees(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can manage student fees.");
                    }
                    break;
                case 8:
                    // Managing student fines
                    if (role.equals("Administrator")) {
                        manageFines(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can manage student fines.");
                    }
                    break;
                case 9:
                    // Enrolling a student in a course
                    if (role.equals("Administrator")) {
                        enrollInUniversityCourse(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can enroll students in courses.");
                    }
                    break;
                case 10:
                    // Displaying courses of a student by ID
                    displayStudentCourses(dataCell, scanner,CAC);
                    break;
                case 11:
                    // Adding previous details and courses for a student
                    if (role.equals("Administrator")) {
                        addStudentDetails(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can add student details.");
                    }
                    break;
                case 12:
                    // Generating student transcript
                    generateTranscript(dataCell, scanner,CAC);
                    break;
                case 13:
                    // Calculating GPA for a student
                    if (role.equals("Administrator")) {
                        calculateGPA(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can calculate GPA.");
                    }
                    break;
                case 14:
                    // Calculating CGPA for a student
                    if (role.equals("Administrator")) {
                        calculateCGPA(dataCell, scanner,CAC);
                    } else {
                        System.out.println("Access denied. Only administrators can calculate CGPA.");
                    }
                    break;
                case 15:
                    // Adding university courses
                    if (role.equals("Administrator")) {
                        addUniversityCourses(dataCell);
                        writeCoursesToFile(dataCell,"University_Course.txt");
                        System.out.println("University courses added successfully.");
                    } else {
                        System.out.println("Access denied. Only administrators can add university courses.");
                    }
                    break;
                case 16:
                    // Exiting or returning to login screen
                    StudentFile.writeStudentsToFile(dataCell, "students.txt");
                    char exitChoice;
                    System.out.println("Press E to exit or R to return to login screen: ");
                    exitChoice = scanner.next().charAt(0);
                    if (exitChoice == 'E' || exitChoice == 'e') {
                        System.out.println("Exiting program. Goodbye!");
                        Main.setExitProgram(false);
                        Main.setEND(true);

                    } else {
                        System.out.println("Returning to login screen.");
                        Main.setExitProgram(true);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }


        } while (choice != 16);

        scanner.close();
    }

    private void calculateCGPA(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println( "Enter student ID to calculate CGPA: ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1)
        {
            cac.getS().calculateCGPA(dataCell,index);
            System.out.println( "CGPA calculated successfully." );
        }
        else {
            System.out.println("Student not found.");
        }
    }

    private void calculateGPA(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println( "Enter student ID to calculate GPA: ");
         studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1)
        {
          cac.getS().calculateGPA(dataCell.getStuds()[index]);
            System.out.println( "GPA calculated successfully." );
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public void generateTranscript(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println("Enter student ID to enter student : ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1)
        {
           cac.getM().generateTranscript(dataCell, index);
        }
        else {
            System.out.println("Student not found." );
        }
    }

    public void addStudentDetails(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println( "Enter student ID to enter student : ");
       studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1)
        {
           cac.getS(). Studentdetails(dataCell, index);
            cac.getC().addCourseDetails(dataCell, index);
        }
        else {
            System.out.println("Student not found.");
        }
    }

    private void displayStudentCourses(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println( "Enter student ID to display: ");
         studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
           cac.getM().coursedisplay(dataCell, index);
        }
        else {
            System.out.println( "Student not found." );
        }
    }

    public void enrollInUniversityCourse(DataCell dataCell, Scanner scanner, CallAllClasses cac) {
        String studentID;
        System.out.println("Enter student ID to enter course: ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
           cac.getE(). enrollInUniversityCourse(dataCell, dataCell.getStuds()[index]);
        }
        else {
            System.out.println( "Student not found." );
        }
    }

    private void manageFines(DataCell dataCell, Scanner scanner,CallAllClasses CAC) {
        String studentID;
        System.out.println("Enter student ID to manage fees: ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
            CAC.getS().manageFines(dataCell, index);
        }
        else {
            System.out.println( "Student not found." );
        }
    }
    private void manageFees(DataCell dataCell, Scanner scanner,CallAllClasses CAC) {
        String studentID;
        System.out.println("Enter student ID to manage fees: ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
            CAC.getS().manageFees(dataCell, index);
        }
        else {
            System.out.println( "Student not found." );
        }
    }


    public  void searchStudentById(DataCell dataCell, Scanner scanner,CallAllClasses CAC) {
        String studentID;
        System.out.println("Enter student ID to search: ");
         studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
            System.out.println("Student found at index " + index + "." );
            CAC.getM().displayStudentInfoWithCourses(dataCell, index);
        }
        else {
            System.out.println( "Student not found." );
        }
    }

    private void displayStudentInfo(DataCell dataCell, Scanner scanner,CallAllClasses CAC) {
        String studentID;
        System.out.println( "Enter student ID to display: ");
        studentID=scanner.next();
        int index = searchStudentByID(dataCell, studentID);
        if (index != -1) {
           CAC.getM().displayStudentInfoWithCourses(dataCell, index);
        }
        else {
            System.out.println("Student not found." );
        }
    }

    public void addNewStudent(DataCell dataCell, CallAllClasses CAG) {
        Student newStudent = new Student();


        String studentID;
        boolean idExists;
        do {
            studentID = ErrorHandling.promptString("Enter student ID: ");
            idExists = searchStudentByID(dataCell, studentID) != -1;
            if (idExists) {
                errorHandler.displayErrorMessage("Student ID already exists. Please enter a different ID.");
            }
        } while (idExists);

        newStudent.setID(studentID);

        newStudent.setName(ErrorHandling.promptString("Enter student name: "));

        String contact;
        do {
            contact = ErrorHandling.promptString("Enter Student Contact Number (11 digits): ");
            if (contact.length() != 11) {
                errorHandler.displayErrorMessage("Invalid Contact Number. Please enter an 11-digit number.");
            }
        } while (contact.length() != 11);
        newStudent.setContact(contact);

        newStudent.getEnroll().setAdd_date(ErrorHandling.promptString("Enter Student admission date (YYYY-MM-DD): "));

        newStudent.getEnroll().setProgramtostudy(ErrorHandling.promptString("Enter Student Program to Study: "));

        newStudent.getEnroll().setDegree(ErrorHandling.promptString("Enter Student Degree: "));

        newStudent.getEnroll().setFscmarks(ErrorHandling.promptInt("Enter Student FSC marks: "));

        newStudent.getEnroll().setMatricmarks(ErrorHandling.promptInt("Enter Student Matric marks: "));

        newStudent.setFees(ErrorHandling.promptInt("Enter student Fee: "));

        newStudent.setFines(ErrorHandling.promptInt("Enter student Fines: "));

        CAG.getS().addStudent(dataCell, newStudent);
        StudentFile.writeStudentsToFile(dataCell, "students.txt");

    }

    public void updateStudentInfo(DataCell dataCell,Scanner scanner, CallAllClasses CAC)
    {
        String studentID;
        System.out.println( "Enter student ID to update: ");
        studentID=scanner.next();
        CAC.getS().updateStudentInfo(dataCell, searchStudentByID(dataCell, studentID));
    }


}