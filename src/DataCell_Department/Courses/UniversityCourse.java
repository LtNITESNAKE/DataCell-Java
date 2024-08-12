package DataCell_Department.Courses;
import Utility.ConstantVal;
import Utility.ErrorHandling;
import Users.DataCell;

public class UniversityCourse {
    private String course_names;
    private String course_codes;
    private int credit_hours;
    private int semester;
    private String prerequisite_course;
    private float passingMarks = 50.0F;

    public void initializeCourse() {

        course_names = ErrorHandling.promptString("Enter Course Name:");

        course_codes = ErrorHandling.promptString("Enter Course Code:");

        credit_hours = ErrorHandling.promptInt("Enter Credit Hours:");

        semester = ErrorHandling.promptInt("Enter Semester:");

        System.out.println("Does this course have any prerequisites? Press 'y' to add. Any other key to exit.");
        char s = ErrorHandling.promptChar("Enter your choice:");

        if (s == 'Y' || s == 'y') {

            prerequisite_course = ErrorHandling.promptString("Enter Prerequisite Course:");
        }
    }
   public static void displayUniversityCourses(DataCell dataCell) {
       System.out.println("University Courses:");

        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            System.out.println("Course Name: " + dataCell.UnivCourses[i].course_names );
            System.out.println("Course Code: " + dataCell.UnivCourses[i].course_codes );
            System.out.println("Credit Hours: " + dataCell.UnivCourses[i].credit_hours );
            System.out.println("Prerequisite Course: " + dataCell.UnivCourses[i].prerequisite_course );
            System.out.println("-----------------" );
        }
    }
    public static void addUniversityCourses(DataCell dataCell) {
        for (int i = 0; i <ConstantVal.getCourse(); ++i) {
            System.out.println ("Enter details for University Course " + (i + 1));
            dataCell.UnivCourses[i]=new UniversityCourse();
            dataCell.UnivCourses[i].initializeCourse();
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
