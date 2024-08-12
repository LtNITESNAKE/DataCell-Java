package DataCell_Department.TASKMANAGER;
import Utility.ConstantVal;
import DataCell_Department.Courses.Courses;
import DataCell_Department.Enrollment.Student;
import Users.DataCell;

import java.util.*;
public class Menu {
   public static Scanner scanner=new Scanner(System.in);

  
    public int AdministratorMenu() {
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

    public int Menuforuser() {
        System.out.println("DataCell Department Menu:");
        System.out.println("3. Display Student Information");
        System.out.println("4. Display All Students");
        System.out.println("5. Search Student by ID");
        System.out.println("6. Sort Students by ID");
        System.out.println("10. Course Display By ID");
        System.out.println("12. Generate Transcript");
        System.out.println("16. EXIT");
        System.out.println("Enter your choice");
        return scanner.nextInt();

    }

    void generateTranscript(DataCell department, int index) {
        float cgpa = department.getStuds()[index].getCgpa();
        System.out.println("------- Transcript for Student ID: " + department.getStuds()[index].getID() + " -------");
        System.out.println("Name: " + department.getStuds()[index].getName());
        System.out.println("Admission Date: " + department.getStuds()[index].getEnroll().getAdd_date());

        System.out.println("------- Courses -------");
        for (int i = 0; i < ConstantVal.getCourse(); i++) {
            System.out.println("Course " + (i + 1) + ": " + department.getStuds()[index].Course[i].getCourse_names());
            System.out.println("Code: " + department.getStuds()[index].Course[i].getCourse_codes());
            System.out.println("Credit Hours: " + department.getStuds()[index].Course[i].getCourse_codes());
            System.out.println("Grade: " + department.getStuds()[index].Course[i].getGrades());
            System.out.println("Prerequisite Course: " + department.getStuds()[index].Course[i].getPrerequisite_course());
            System.out.println("Prerequisite Completed: " + (department.getStuds()[index].Course[i].isPrerequisite_completed() ? "Yes" : "No"));
            System.out.println("------------------------");
        }

        System.out.println("CGPA: " + department.getStuds()[index].getCgpa());
    }


    public static void viewUserProfile(String role) {
        System.out.println("Welcome to the system!");
        System.out.println("User Profile:");
        System.out.println("-----------------------");
        System.out.println("Role:"+ role);
        System.out.println("------------------------");
    }

void displayStudentInfoWithCourses(DataCell department, int index) {
    Student student = department.getStuds()[index];
    if (student != null) {
        System.out.println("\nStudent Information:");
        System.out.println("Student ID: " + student.getID());
        System.out.println("Name: " + student.getName());
        System.out.println("Contact no: " + student.getContact());
        System.out.println("GPA: " + student.getGpa());
        System.out.println("Fees: RS" + student.getFees());
        System.out.println("Fines: RS" + student.getFines());

        // Display course details
        System.out.println("\nCourse Details:");
        Courses[] courses = student.Course;
        if (courses != null) {
            for (Courses course : courses) {
                if (course != null) {
                    System.out.println("-----------------");
                    if (course.getCourse_names() != null) {
                        System.out.println("Course Name: " + course.getCourse_names());
                    }
                    if (course.getCourse_codes() != null) {
                        System.out.println("Course Code: " + course.getCourse_codes());
                    }
                    System.out.println("Credit Hours: " + course.getCredit_hours());
                    System.out.println("Grade: " + course.getGrades());

                    // Display prerequisite information
                    System.out.println("Prerequisite Completed: " + (course.isPrerequisite_completed() ? "Yes" : "No"));

                    String prerequisiteCourse = course.getPrerequisite_course();
                    if (prerequisiteCourse != null && !prerequisiteCourse.isEmpty()) {
                        System.out.println("Prerequisite Course: " + prerequisiteCourse);
                    }
                }
            }
        }
    } else {
        System.out.println("Student information not found.");
    }
}

    void coursedisplay(DataCell datacell, int index) {
        Student student = datacell.getStuds()[index];
        if (student != null) {
            System.out.println("\nStudent Information:");
            System.out.println("Student ID: " + student.getID());
            System.out.println("Name: " + student.getName());
            System.out.println("GPA: " + student.getGpa());

            // Display course details
            System.out.println("\nCourse Details:");
            Courses[] courses = student.Course;
            if (courses != null) {
                for (Courses course : courses) {
                    if (course != null) {
                        System.out.println("-----------------");
                        if (course.getCourse_names() != null) {
                            System.out.println("Course Name: " + course.getCourse_names());
                        }
                        if (course.getCourse_codes() != null) {
                            System.out.println("Course Code: " + course.getCourse_codes());
                        }
                        System.out.println("Credit Hours: " + course.getCredit_hours());
                        System.out.println("Grade: " + course.getGrades());

                        // Display prerequisite information
                        System.out.println("Prerequisite Completed: " + (course.isPrerequisite_completed() ? "Yes" : "No"));

                        String prerequisiteCourse = course.getPrerequisite_course();
                        if (prerequisiteCourse != null && !prerequisiteCourse.isEmpty()) {
                            System.out.println("Prerequisite Course: " + prerequisiteCourse);
                        }
                    }
                }
            }
        } else {
            System.out.println("Student information not found.");
        }
    }


    void displayAllStudents(DataCell department) {
        if (department.getNumStudents() == 0) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nAll Students:");

            for (int i = 0; i < department.getNumStudents(); ++i) {
                System.out.println("-----------------");
                displayStudentInfoWithCourses(department, i);
            }

            System.out.println("-----------------");
        }
    }

}
