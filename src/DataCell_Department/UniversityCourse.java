package DataCell_Department;
import java.util.*;
public class UniversityCourse {
    private String course_names;
    private String course_codes;
    private int credit_hours;
    private int semester;
    private String prerequisite_course;
    private float passingMarks = 50.0F;

    void initializeCourse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Course Name: ");

        course_names = sc.next();
        System.out.println("Enter Course Code: ");
        course_codes = sc.next();
        System.out.println("Enter Credit Hours: ");
        credit_hours = sc.nextInt();
        System.out.println("Enter Semester: ");
        semester = sc.nextInt();
        System.out.println("Enter Prerequisite Course (if any): ");
        prerequisite_course = sc.next();
    }
   public static void displayUniversityCourses(DataCell  dataCell) {
       System.out.println("University Courses:");

        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            System.out.println("Course Name: " + dataCell.UnivCourses[i].course_names );
            System.out.println("Course Code: " + dataCell.UnivCourses[i].course_codes );
            System.out.println("Credit Hours: " + dataCell.UnivCourses[i].credit_hours );
            System.out.println("Prerequisite Course: " + dataCell.UnivCourses[i].prerequisite_course );
            System.out.println("-----------------" );
        }
    }


    public String getCourse_codes() {
        return course_codes;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public float getPassingMarks() {
        return passingMarks;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse_names() {
        return course_names;
    }

    public String getPrerequisite_course() {
        return prerequisite_course;
    }

    public void setCourse_codes(String course_codes) {
        this.course_codes = course_codes;
    }

    public void setCourse_names(String course_names) {
        this.course_names = course_names;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setPassingMarks(float passingMarks) {
        this.passingMarks = passingMarks;
    }

    public void setPrerequisite_course(String prerequisite_course) {
        this.prerequisite_course = prerequisite_course;
    }
}
