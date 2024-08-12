package DataCell_Department;
import java.util.*;
public class Courses {
    private  String course_names;
    private String course_codes;
    private  int credit_hours;
    private  char grades;
    private  boolean prerequisite_completed;
    private  String prerequisite_course;
    private  float midTermMarks ;
    private float labMarks ;
    private  float finalExamMarks ;

    public String getCourse_names() {
        return course_names;
    }

    public void setCourse_names(String course_names) {
        this.course_names = course_names;

    }

    public String getCourse_codes() {
        return course_codes;
    }

    public void setCourse_codes(String course_codes) {
        this.course_codes = course_codes;
    }

    public char getGrades() {
        return grades;
    }

    public void setGrades(char grades) {
        this.grades = grades;
    }

    public boolean isPrerequisite_completed() {
        return prerequisite_completed;
    }

    public void setPrerequisite_completed(boolean prerequisite_completed) {
        this.prerequisite_completed = prerequisite_completed;
    }

    public String getPrerequisite_course() {
        return prerequisite_course;
    }

    public void setPrerequisite_course(String prerequisite_course) {
        this.prerequisite_course = prerequisite_course;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public float getMidTermMarks() {
        return midTermMarks;
    }

    public void setMidTermMarks(float midTermMarks) {
        this.midTermMarks = midTermMarks;
    }

    public float getFinalExamMarks() {
        return finalExamMarks;
    }

    public void setFinalExamMarks(float finalExamMarks) {
        this.finalExamMarks = finalExamMarks;
    }

    public float getLabMarks() {
        return labMarks;
    }

    public void setLabMarks(float labMarks) {
        this.labMarks = labMarks;
    }
    void course_prereq(DataCell dataCell, int index)
    {
        Scanner cin=new Scanner(System.in);
        for (int i = 0; i < ConstantVal.getCourse(); i++)
        {
            // Create a new Student object for each course
            Student newStudent = null;
            System.out.println( "Enter course " + i + 1 + " name for semester: ");
            cin.nextLine();
             newStudent.Course[index].course_names=cin.nextLine();

            System.out.println("Enter Course " + i + 1 + " code for semester: ");
            cin.nextLine();
             newStudent.Course[index].course_codes=cin.nextLine();

            System.out.println("Enter Course " + i + 1 + " Credit hours for semester: ");

             newStudent.Course[index].credit_hours=cin.nextInt();
             System.out.println("Enter student Grade for this semester: ");
             newStudent.Course[index].grades=cin.next().charAt(0);

            // Prerequisite information
            System.out.println("Does this course have a prerequisite? (y/n): ");
            char hasPrerequisite;
             hasPrerequisite=cin.next().charAt(0);

            if (hasPrerequisite == 'y' || hasPrerequisite == 'Y')
            {
                System.out.println("Enter the name of the prerequisite course: ");
                 newStudent.Course[index].prerequisite_course=cin.next();
            }

            // Set prerequisite completion based on grade
            newStudent.Course[index].prerequisite_completed = (newStudent.Course[index].grades != 'F' && newStudent.Course[index].grades != 'f');

            // Add the current course information to the student at the given index
            dataCell.getStuds()[index].Course[i] = newStudent.Course[index];
        }

        System.out.println("Student added successfully.");
    }
}
