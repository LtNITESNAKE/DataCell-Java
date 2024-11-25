package DataCell_Department.Courses;
import Utility.ConstantVal;
import DataCell_Department.TASKMANAGER.Menu;
import Users.DataCell;

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


    public void addCourseDetails(DataCell dataCell, int index) {
        System.out.println("Enter course details for student " + dataCell.getStuds()[index].getID() + ":" );
        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            System.out.println("Enter grade for course " + (i + 1) + ": ");
             dataCell.getStuds()[index].Course[i].setGrades(Menu.scanner.next().charAt(0));
        }
    }
}
